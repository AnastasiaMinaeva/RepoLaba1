import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {
    @Test
    public void TestGetters()
    {
        Product p = new Product("Кузьмино", "Молочная продукция");
        assertEquals("Кузьмино", p.getName());
        assertEquals("Молочная продукция", p.getDescription());
    }

    @Test
    public void TestEquals()
    {
        Product p1 = new Product("Солнечное", "Молочная продукция");
        Product p2 = new Product("Лунное", "Мясная продукция");
        Product p3 = new Product("Солнечное", "Молочная продукция");

        assertNotEquals(p1, p2);
        assertEquals(p1, p3);
    }

    @Test
    public void TestToString()
    {
        Product p2 = new Product("Лунное", "Мясная продукция");
        String expectedResult = "Product{name=Лунное'description=Мясная продукция'}";
        assertEquals(expectedResult, p2.toString());
    }
}
