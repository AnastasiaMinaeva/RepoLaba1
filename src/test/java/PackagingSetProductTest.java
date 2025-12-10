import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class PackagingSetProductTest {
    @Test
    public void TestGetterSet() {
        Packaging p1 = new Packaging("Коробочка", 1);
        Packaging p2 = new Packaging("Бутылка", 1);
        Packaging p3 = new Packaging("Коробка", 2);
        PackingPieceProduct ppp1 = new PackingPieceProduct(p1, "Конфета", "Сладкая", 0.1, 10);
        PackagingWeightProduct pwp1 = new PackagingWeightProduct(p2,"Вода", "Речная", 3);
        Weightable[] sets = {ppp1, pwp1};
        PackagingSetProduct psp = new PackagingSetProduct("Набор1",p3, sets);

        assertEquals("Коробочка", p1.getName());
        assertEquals("Бутылка",  p2.getName());

        Weightable[] returnedSets = psp.getSets();
        assertEquals(2, returnedSets.length);
        assertEquals(ppp1, returnedSets[0]);
        assertEquals(pwp1, returnedSets[1]);
    }

    @Test
    public void TestGetBruttoAndNettoMassKg() {
        Packaging p1 = new Packaging("Коробочка", 1);
        Packaging p2 = new Packaging("Бутылка", 1);
        Packaging p3 = new Packaging("Коробка", 2);
        PackingPieceProduct ppp1 = new PackingPieceProduct(p1, "Конфета", "Сладкая", 0.1, 10);
        PackagingWeightProduct pwp1 = new PackagingWeightProduct(p2,"Вода", "Речная", 3);
        Weightable[] sets = {ppp1, pwp1};
        PackagingSetProduct psp = new PackagingSetProduct("Набор1" ,p3, sets);

        Double.compare(6, psp.getBruttoMassKg());
        Double.compare(8, psp.getNettoMassKg());
    }

    @Test
    public void TestEqualsSets() {
        Packaging p1 = new Packaging("Коробочка", 1);
        Packaging p2 = new Packaging("Бутылка", 1);
        Packaging p3 = new Packaging("Коробка", 2);

        PackingPieceProduct ppp1 = new PackingPieceProduct(p1, "Конфета", "Сладкая", 0.1, 10);
        PackagingWeightProduct pwp1 = new PackagingWeightProduct(p2,"Вода", "Речная", 3);
        Weightable[] sets = {ppp1, pwp1};
        PackagingSetProduct psp = new PackagingSetProduct("Набор1" ,p3, sets);

        Packaging pp = new Packaging("Коробочка", 1);
        Packaging pp2 = new Packaging("Бутылка", 1);
        Packaging pp3 = new Packaging("Коробка", 2);
        PackingPieceProduct ppp2 = new PackingPieceProduct(pp, "Конфета", "Сладкая", 0.1, 10);
        PackagingWeightProduct pwp2 = new PackagingWeightProduct(pp2,"Вода", "Речная", 3);
        Weightable[] sets1 = {ppp2, pwp2};
        PackagingSetProduct psp1 = new PackagingSetProduct("Набор1",pp3, sets1);

        Packaging p1p = new Packaging("Коробочка1", 11);
        Packaging p2p = new Packaging("Бутылка1", 11);
        Packaging p3p = new Packaging("Коробка1", 22);
        PackingPieceProduct ppp3 = new PackingPieceProduct(p1p, "Конфета1", "Сладкая1", 0.11, 11);
        PackagingWeightProduct pwp3 = new PackagingWeightProduct(p2p,"Вода1", "Речная", 4);
        Weightable[] sets2 = {ppp3, pwp3};
        PackagingSetProduct psp3 = new PackagingSetProduct("Набор3",p3p, sets2);

        assertEquals(psp, psp1);
        assertNotEquals(psp1, psp3);
    }

    @Test
    public void TestToString()
    {
        Packaging p1 = new Packaging("Коробочка", 1);
        Packaging p2 = new Packaging("Бутылка", 1);
        Packaging p3 = new Packaging("Коробка", 2);

        PackingPieceProduct ppp1 = new PackingPieceProduct(p1, "Конфета", "Сладкая", 0.1, 10);
        PackagingWeightProduct pwp1 = new PackagingWeightProduct(p2,"Вода", "Речная", 3);

        Weightable[] sets = {ppp1, pwp1};

        PackagingSetProduct psp = new PackagingSetProduct("Набор1",p3, sets);

        String actualResult = psp.toString();

        assertTrue(actualResult.contains("PackagingSetProduct"));
        assertTrue(actualResult.contains("Коробка"));
    }
}
