import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServiceProductTest {

    @Test
    public void testCountByFilter() {
        Packaging packaging = new Packaging("Box", 0.5);

        Weightable[] products = {
                new PackagingWeightProduct(packaging, "Apple", "Fresh apple", 1.0),
                new PackagingWeightProduct(packaging, "Banana", "Yellow banana", 1.5),
                new PackagingWeightProduct(packaging, "Avocado", "Green avocado", 0.8),
                new PackingPieceProduct(packaging, "Orange", "Citrus orange", 0.2, 5.0)
        };

        ProductBatch batch = new ProductBatch("Fruits batch", products);
        ServiceProduct service = new ServiceProduct();

        Filter startsWithA = new BeginStringFilter("A");

//        BeginStringFilter startsWithA = new BeginStringFilter("A"); // норм
//        Filter startsWithA = new Filter("A"); // плохо - ошибка
//        BeginStringFilter startsWithA = new Filter("A"); // ошибка

        assertEquals(2, service.countByFilter(batch, startsWithA));

        Filter containsAn = new ContainsStringFilter("an");
        assertEquals(2, service.countByFilter(batch, containsAn));

        Filter endsWithE = new EndsStringFilter("e");
        assertEquals(2, service.countByFilter(batch, endsWithE));

        Filter startsWithZ = new BeginStringFilter("Z");
        assertEquals(0, service.countByFilter(batch, startsWithZ));
    }

    @Test
    public void testCountByFilterDeep() {
        Packaging packaging = new Packaging("Box", 0.5);

        Weightable[] innerProducts = {
                new PackagingWeightProduct(packaging, "Inner Apple", "Inner fresh apple", 0.5),
                new PackingPieceProduct(packaging, "Inner Orange", "Inner citrus orange", 0.1, 3.0)
        };

        PackagingSetProduct nestedSet = new PackagingSetProduct("Nested Set", packaging, innerProducts);

        Weightable[] products = {
                new PackagingWeightProduct(packaging, "Apple", "Fresh apple", 1.0),
                new PackagingWeightProduct(packaging, "Banana", "Yellow banana", 1.5),
                nestedSet
        };

        ProductBatch batch = new ProductBatch("Complex batch", products);
        ServiceProduct service = new ServiceProduct();

        Filter containsInner = new ContainsStringFilter("Inner");
        assertEquals(1, service.countByFilterDeep(batch, containsInner));

        Filter containsApple = new ContainsStringFilter("Apple");
        assertEquals(2, service.countByFilterDeep(batch, containsApple));
    }

    @Test
    public void testCheckAllWeighted1() {
        Packaging packaging = new Packaging("Box", 0.5);

        Weightable[] weightedProducts = {
                new PackagingWeightProduct(packaging, "Apple", "Fresh apple", 1.0),
                new PackagingWeightProduct(packaging, "Banana", "Yellow banana", 1.5)
        };

        ProductBatch weightedBatch = new ProductBatch("Weighted batch", weightedProducts);
        ServiceProduct service = new ServiceProduct();

        assertTrue(service.checkAllWeighted(weightedBatch));
    }

    @Test
    public void testCheckAllWeighted2() {
        ServiceProduct service = new ServiceProduct();

        Packaging packaging = new Packaging("Box", 0.5);

        Weightable[] mixedProducts = {
                new PackagingWeightProduct(packaging, "Apple", "Fresh apple", 1.0),
                new PackingPieceProduct(packaging, "Orange", "Citrus orange", 0.2, 5.0)
        };

        ProductBatch mixedBatch = new ProductBatch("Mixed batch", mixedProducts);

        assertFalse(service.checkAllWeighted(mixedBatch));
    }

    @Test
    public void testCheckAllWeighted3() {
        ServiceProduct service = new ServiceProduct();

        Packaging packaging = new Packaging("Box", 0.5);

        Weightable[] innerProducts = {
                new PackingPieceProduct(packaging, "Inner Orange", "Inner citrus orange", 0.1, 3.0)
        };

        PackagingSetProduct nestedSet = new PackagingSetProduct("Nested Set", packaging, innerProducts);
        Weightable[] complexProducts = {
                new PackagingWeightProduct(packaging, "Apple", "Fresh apple", 1.0),
                nestedSet
        };

        ProductBatch complexBatch = new ProductBatch("Complex batch", complexProducts);

        assertFalse(service.checkAllWeighted(complexBatch));
    }

    @Test
    public void testEmptyBatch() {
        Weightable[] emptyProducts = {};
        ProductBatch emptyBatch = new ProductBatch("Empty batch", emptyProducts);
        ServiceProduct service = new ServiceProduct();

        Filter anyFilter = new ContainsStringFilter("any");
        assertEquals(0, service.countByFilter(emptyBatch, anyFilter));
        assertEquals(0, service.countByFilterDeep(emptyBatch, anyFilter));
        assertTrue(service.checkAllWeighted(emptyBatch));
    }
}