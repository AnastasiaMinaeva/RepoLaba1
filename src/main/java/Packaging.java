import java.util.Objects;

public class Packaging{
    final private String name;
    final private double massKgPerPackaging;

    public Packaging(String name, double massKgPerPackaging)
    {
        this.name = name;
        this.massKgPerPackaging = massKgPerPackaging;
    }

    public String getName() {
        return name;
    }

    public double getMassKgPerPackaging() {
        return massKgPerPackaging;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, massKgPerPackaging);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){return false;}
        if( o == null || getClass() != o.getClass()) {return false;}
        Packaging packaging = (Packaging) o;
    return Double.compare(massKgPerPackaging, packaging.massKgPerPackaging) == 0 && Objects.equals(name, packaging.name);
    }

    @Override
    public String toString()
    {
        return "Product{" +
                "name=" + name + '\'' +
                "massKgPerPackaging=" + massKgPerPackaging + '\'' +
                "}";
    }

}

