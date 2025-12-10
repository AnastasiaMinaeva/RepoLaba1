import java.util.Objects;

public class PackingPieceProduct extends PieceProduct implements Weightable {
    final private Packaging packaging;
    final private double quantityPiecesKg;

    public PackingPieceProduct(Packaging packaging, String name, String description , double pieceMass1Kg, double quantityPiecesKg)
    {
        super(name, description, pieceMass1Kg);
        this.packaging = packaging;
        this.quantityPiecesKg = quantityPiecesKg;
    }

    public Packaging getPackaging() {return packaging;}

    public double getQuantityPiecesKg() {return quantityPiecesKg;}

    public double getNettoMassKg() {
        return quantityPiecesKg * getPieceMass1Kg();
    }

    public double getBruttoMassKg()
    {

        return getNettoMassKg() + packaging.getMassKgPerPackaging();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PackingPieceProduct that = (PackingPieceProduct) o;
        return Double.compare(quantityPiecesKg, that.quantityPiecesKg) == 0 && Objects.equals(packaging, that.packaging);
    }

    @Override
    public int hashCode() {
        return Objects.hash(packaging, quantityPiecesKg);
    }

    @Override
    public String toString() {
        return "PackingPieceProduct{" +
                "packaging=" + packaging +
                ", quantityPiecesKg=" + quantityPiecesKg +
                '}';
    }
}
