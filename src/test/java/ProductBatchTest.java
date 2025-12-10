import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductBatchTest {

    @Test
    public void TestGetter() {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        Packaging packaging2 = new Packaging("Пакет", 0.05);

        PackagingWeightProduct weightProduct = new PackagingWeightProduct(packaging2, "Молоко", "Свежее", 1.0);
        PackingPieceProduct pieceProduct = new PackingPieceProduct(packaging2, "Хлеб", "Белый", 0.5, 2);

        Weightable[] products = {weightProduct, pieceProduct};
        ProductBatch batch = new ProductBatch("Склад 1", products);
        Weightable[] returnedProducts = batch.getBatchProduct();
        double actualMass = batch.getMassAllBatch();

        Double.compare(2.1, actualMass);
        assertEquals("Склад 1", batch.getDescription());
        assertNotNull(returnedProducts);
        assertEquals(2, returnedProducts.length);
        assertTrue(returnedProducts.length > 0);
    }

    @Test
    public void TestGetMassAllBatch() {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        Packaging packaging2 = new Packaging("Пакет", 0.05);

        PackagingWeightProduct weightProduct = new PackagingWeightProduct(packaging2, "Молоко", "Свежее", 1.0);
        PackingPieceProduct pieceProduct = new PackingPieceProduct(packaging2, "Хлеб", "Белый", 0.5, 2);

        Weightable[] products = {weightProduct, pieceProduct};
        ProductBatch batch = new ProductBatch("Склад 1", products);
        double mass = batch.getMassAllBatch();
        assertTrue(mass > 0);
    }

    @Test
    public void TestEquals()
    {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        Packaging packaging2 = new Packaging("Пакет", 0.05);

        // Создаем простые товары для тестирования
        PackagingWeightProduct weightProduct = new PackagingWeightProduct(packaging2, "Молоко", "Свежее", 1.0);
        PackingPieceProduct pieceProduct = new PackingPieceProduct(packaging2, "Хлеб", "Белый", 0.5, 2);

        Weightable[] products1 = {weightProduct, pieceProduct};
        Weightable[] products2 = {weightProduct, pieceProduct};

        ProductBatch batch1 = new ProductBatch("Склад 1", products1);

        ProductBatch batch2 = new ProductBatch("Склад 1", products2);

        assertNotNull(batch1);
        assertNotNull(batch2);

        assertEquals(batch1.getDescription(), batch2.getDescription());
        assertEquals(batch1.getBatchProduct().length, batch2.getBatchProduct().length);
        Double.compare(batch1.getMassAllBatch(), batch2.getMassAllBatch());
    }


    @Test
    public void TestToString() {
        Packaging packaging1 = new Packaging("Коробка", 1.0);
        Packaging packaging2 = new Packaging("Пакет", 0.05);

        PackagingWeightProduct weightProduct = new PackagingWeightProduct(packaging2, "Молоко", "Свежее", 1.0);
        PackingPieceProduct pieceProduct = new PackingPieceProduct(packaging2, "Хлеб", "Белый", 0.5, 2);

        Weightable[] products = {weightProduct, pieceProduct};
        ProductBatch batch = new ProductBatch("Склад 1", products);

        String actualResult = batch.toString();
        System.out.println("Результат toString: " + actualResult);

        assertNotNull(actualResult);
        assertFalse(actualResult.isEmpty());
        assertTrue(actualResult.contains("ProductBatch"));
        assertTrue(actualResult.contains("Склад 1"));
    }
}