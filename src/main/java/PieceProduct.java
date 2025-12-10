import java.util.Objects;

public class PieceProduct extends Product{
   final private double pieceMass1Kg;

   public PieceProduct(String name, String description, double pieceMass1Kg) //Конструктор
   {
       super(name, description);
       this.pieceMass1Kg = pieceMass1Kg;
   }

   public double getPieceMass1Kg()
   {
       return pieceMass1Kg;
   }

   @Override
    public boolean equals(Object o)
   {
       if ( this == o){return false;}
       if(o == null || getClass() != o.getClass()){return false;}
       PieceProduct pieceProduct = (PieceProduct) o;
       return Double.compare(pieceMass1Kg, pieceProduct.pieceMass1Kg) == 0;
   }
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pieceMass1Kg);
    }

    @Override
    public String toString() {
        return "PieceProduct{" +
                "name=" + name + '\'' +
                "description=" + description + '\'' +
                "pieceMass1Kg=" + pieceMass1Kg + '\'' +
                '}';
    }
}
