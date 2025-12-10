import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class PackagingWeightProductTest{
    @Test
    public  void TestGetter()
    {
        Packaging p1 = new Packaging("Коробка", 1.0);
        PackagingWeightProduct ppp1 = new PackagingWeightProduct(p1, "Молоко", "Молочный продукт", 0.5);
        assertEquals("Коробка", p1.getName());
        Double.compare(4.0, ppp1.getQuantityKg());

        Double.compare(2.0, ppp1.getNettoMassKg());
        Double.compare(3.0, ppp1.getBruttoMassKg());
    }

    @Test
    public void TestToString()
    {
        Packaging p1 = new Packaging("Коробка", 1.0);
        PackagingWeightProduct ppp1 = new PackagingWeightProduct(p1, "Молоко", "Молочный продукт", 0.5);
        String actualResult = ppp1.toString();
        assertTrue(actualResult.contains("Коробка"));
        assertTrue(actualResult.contains("0.5"));
    }

    @Test
    public void  TestEquals1()
    {
        Packaging p1 = new Packaging("Коробка", 1.0);
        PackagingWeightProduct ppp1 = new PackagingWeightProduct(p1, "Молоко", "Молочный продукт", 0.5);
        Packaging p2 = new Packaging("Коробка", 1.0);
        PackagingWeightProduct ppp2 = new PackagingWeightProduct(p2, "Молоко", "Молочный продукт", 0.5);
        Packaging p3 = new Packaging("Коробка деревянная", 2.0);
        PackagingWeightProduct ppp3 = new PackagingWeightProduct(p3, "Бургер", "Фастфуд", 0.3);
        assertEquals(ppp1, ppp2);
        assertNotEquals(ppp1, ppp3);
    }

}
