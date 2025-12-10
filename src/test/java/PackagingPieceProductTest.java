import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class PackagingPieceProductTest{
    @Test
    public  void TestGetter()
    {
        Packaging p1 = new Packaging("Коробка", 1.0);
        PackingPieceProduct ppp1 = new PackingPieceProduct(p1, "Молоко", "Молочный продукт", 0.5, 4.0);
        assertEquals("Коробка", p1.getName());
        Double.compare(4.0, ppp1.getQuantityPiecesKg());

        Double.compare(2.0, ppp1.getNettoMassKg());
        Double.compare(3.0, ppp1.getBruttoMassKg());
    }

    /*@Test
    public void TestToString()
    {
        Packaging p1 = new Packaging("Коробка", 1.0);
        PackingPieceProduct ppp1 = new PackingPieceProduct(p1, "Молоко", "Молочный продукт", 0.5, 4);
        String actualResult = ppp1.toString();
        assertTrue(actualResult.contains("Коробка"));
        assertTrue(actualResult.contains("4"));
    }*/

    @Test
    public void  TestEquals1()
    {
        Packaging p1 = new Packaging("Коробка", 1.0);
        PackingPieceProduct ppp1 = new PackingPieceProduct(p1, "Молоко", "Молочный продукт", 0.5, 4.0);
        Packaging p2 = new Packaging("Коробка", 1.0);
        PackingPieceProduct ppp2 = new PackingPieceProduct(p2, "Молоко", "Молочный продукт", 0.5, 4.0);
        Packaging p3 = new Packaging("Коробка деревянная", 2.0);
        PackingPieceProduct ppp3 = new PackingPieceProduct(p3, "Бургер", "Фастфуд", 0.3, 1.0);
        assertEquals(ppp1, ppp2);
        assertNotEquals(ppp1, ppp3);
    }

}
