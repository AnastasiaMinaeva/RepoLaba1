import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class PieceProductTest {
    @Test
    public void TestGetters()
    {
        PieceProduct pp = new PieceProduct("Лужайкино", "Мясная продукция", 2);
        assertEquals("Лужайкино", pp.getName());
        assertEquals("Мясная продукция", pp.getDescription());
        Double.compare(2, pp.getPieceMass1Kg());
    }

    @Test
    public void TestEquals()
    {
        PieceProduct pp1 = new PieceProduct("Прост", "Сладкое", 2);
        PieceProduct pp2 = new PieceProduct("Лужайкино", "Мясная продукция", 3);
        PieceProduct pp3 = new PieceProduct("Лужайкино", "Мясная продукция", 3);

        assertNotEquals(pp1, pp2);
        assertEquals(pp2,pp3);
    }

    @Test
    public void TestToString()
    {
        PieceProduct pp1 = new PieceProduct("Прост", "Сладкое", 2);
        String expectedResult = "PieceProduct{name=Прост'description=Сладкое'pieceMass1Kg=2.0'}";
        assertEquals(expectedResult, pp1.toString());
    }
}
