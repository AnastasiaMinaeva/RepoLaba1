import java.util.Arrays;
import java.util.Objects;

public class PackagingSetProduct implements Weightable {
    final private Packaging packaging;
    final private Weightable[] sets;
    final private String name;

    public PackagingSetProduct( String name, Packaging packaging, Weightable[] sets) {
        this.packaging = packaging;
        this.sets = sets;
        this.name = name;
    }
    public String getName() {return name;}

    public Packaging getPackaging() {
        return packaging;
    }

    public Weightable[] getSets() {
        return sets;
    }

    public double getBruttoMassKg() {
        return getNettoMassKg() + packaging.getMassKgPerPackaging();
    }

    public double getNettoMassKg() {
        double total = 0.0;
        for (int i = 0; i < sets.length; i++) {
            Weightable item = sets[i];
            total += item.getBruttoMassKg();
        }
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagingSetProduct that = (PackagingSetProduct) o;
        return Objects.equals(packaging, that.packaging) && Objects.deepEquals(sets, that.sets) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packaging, Arrays.hashCode(sets),  name);
    }

    @Override
    public String toString() {
        return "PackagingSetProduct{" +
                "packaging=" + packaging +
                ", sets=" + Arrays.toString(sets) +
                ", name='" + name + '\'' +
                '}';
    }
}