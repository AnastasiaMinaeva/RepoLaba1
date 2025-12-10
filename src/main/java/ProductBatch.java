import java.util.Arrays;
import java.util.Objects;

public class ProductBatch {
    final private String description;
    final private Weightable[] batchProduct;

    public ProductBatch(String description, Weightable[] batchProduct)
    {
        this.description = description;
        this.batchProduct = batchProduct;
    }

    public String getDescription() {
        return description;
    }

    public Weightable[] getBatchProduct() {
        return batchProduct;
    }

    public double getMassAllBatch()
    {
        double totalMassKg = 0.0;

        for (int i = 0; i < batchProduct.length; i++)
        {
            Weightable item = batchProduct[i];
            totalMassKg += item.getBruttoMassKg();

        }
        return totalMassKg;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductBatch that = (ProductBatch) o;
        return Objects.equals(description, that.description) && Objects.deepEquals(batchProduct, that.batchProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, Arrays.hashCode(batchProduct));
    }

    @Override
    public String toString() {
        return "ProductBatch{" +
                "description='" + description + '\'' +
                ", batchProduct=" + Arrays.toString(batchProduct) +
                '}';
    }

}
