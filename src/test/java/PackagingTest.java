import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class PackagingTest {
    @Test
    public void TestGetter()
    {
        Packaging prod = new Packaging("Простоквашино", 15.6);
        assertEquals("Простоквашино", prod.getName());
        Double.compare(15.6, prod.getMassKgPerPackaging());
    }

    @Test
    public void TestEquals()
    {
        Packaging prod1 = new Packaging("Просто", 16);
        Packaging prod2 = new Packaging("Простоквашино", 15.6);
        Packaging prod3 = new Packaging("Простоквашино", 15.6);

        assertNotEquals(prod1, prod2);
        assertEquals(prod2, prod3);
    }

    @Test
    public void TestToString()
    {
        Packaging prod = new Packaging("Простоквашино", 15.6);
        String expectedResult = "Product{name=Простоквашино'massKgPerPackaging=15.6'}";
        assertEquals(expectedResult, prod.toString());

    }
}
