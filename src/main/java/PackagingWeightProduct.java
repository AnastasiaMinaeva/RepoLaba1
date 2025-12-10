import java.util.Objects;

public class PackagingWeightProduct extends WeightProduct implements Weightable {
    final private Packaging packaging;
    final private double quantityKg;

    public PackagingWeightProduct(Packaging packaging, String name, String description, double quantityKg) {
        super(name, description);
        this.packaging = packaging;
        this.quantityKg = quantityKg;
    }

    public double getNettoMassKg() {
        return quantityKg;
    }

    public double getBruttoMassKg() {
        return getQuantityKg() + packaging.getMassKgPerPackaging();
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public double getQuantityKg() {
        return quantityKg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackagingWeightProduct that = (PackagingWeightProduct) o;
        return Double.compare(quantityKg, that.quantityKg) == 0 && Objects.equals(packaging, that.packaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packaging, quantityKg);
    }

    @Override
    public String toString() {
        return "PackagingWeightProduct{" +
                "packaging=" + packaging +
                ", quantityKg=" + quantityKg +
                '}';
    }
}
