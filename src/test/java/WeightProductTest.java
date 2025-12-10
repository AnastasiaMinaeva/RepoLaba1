import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class WeightProductTest {
    @Test
    public void TestGetter()
    {
        WeightProduct wp = new WeightProduct("Лужайкино", "Молочная продукция");

        assertEquals("Лужайкино", wp.getName());
        assertEquals("Молочная продукция", wp.getDescription());
    }

    @Test
    public void TestEquals()
    {
        WeightProduct wp1 = new WeightProduct("Лужайкино", "Молочная продукция");
        WeightProduct wp2 = new WeightProduct("Солнечное", "Сладкая");
        WeightProduct wp3 = new WeightProduct("Лужайкино", "Молочная продукция");

        assertNotEquals(wp1, wp2);
        assertEquals(wp1, wp3);
    }

    @Test
    public void TestToString()
    {
        WeightProduct wp1 = new WeightProduct("Лужайкино", "Молочная продукция");
        String expectedResult = "Product{name=Лужайкино'description=Молочная продукция'}";
                assertEquals(expectedResult, wp1.toString());
    }

}

