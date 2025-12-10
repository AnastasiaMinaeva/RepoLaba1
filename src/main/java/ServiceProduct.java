public class ServiceProduct {

    public int countByFilter(ProductBatch productBatch, Filter filter) {
        int count = 0;
        for (Weightable product : productBatch.getBatchProduct()) {
            if (filter.apply(product.getName())) {
                count++;
            }
        }
        return count;
    }

    public int countByFilterDeep(ProductBatch batch, Filter filter) {
        int count = 0;
        Weightable[] product = batch.getBatchProduct();
        for (int i = 0; i < product.length; i++) {
            Weightable item = product[i];
            if (item instanceof PackagingWeightProduct) {
                String name = ((PackagingWeightProduct) item).getName();
                if (filter.apply(name)) {
                    count++;
                }
            } else if (item instanceof PackingPieceProduct) {
                String name = ((PackingPieceProduct) item).getName();
                if (filter.apply(name)) {
                    count++;
                }
            } else if (item instanceof PackagingSetProduct) {
                if ((containsMatchingProduct((PackagingSetProduct) item, filter))) {
                    count++;
                }
            }
        }
        return count;
    }


    // Вспомогательный метод для рекурсивного поиска в наборе
    private boolean containsMatchingProduct(PackagingSetProduct set, Filter filter) {
        Weightable[] contents = set.getSets();
        for (int i = 0; i < contents.length; i++) {
            Weightable item = contents[i];

            if (item instanceof PackagingWeightProduct) {
                String name = ((PackagingWeightProduct) item).getName();
                if (filter.apply(name)) {
                    return true;
                }
            } else if (item instanceof PackingPieceProduct) {
                String name = ((PackingPieceProduct) item).getName();
                if (filter.apply(name)) {
                    return true;
                }
            } else if (item instanceof PackagingSetProduct) {
                if (containsMatchingProduct((PackagingSetProduct) item, filter)) {
                    return true;
                }
            }
        }
        return false;
    }

        public boolean checkAllWeighted (ProductBatch batch)
        {
            Weightable[] product = batch.getBatchProduct();
            for (int i = 0; i < product.length; i++) {
                Weightable item = product[i];
                if (item instanceof PackingPieceProduct) {
                    return false;
                } else if (item instanceof PackagingSetProduct) {
                    if (!checkAllWeighted((ProductBatch) item)) {
                        return false;
                    }
                }

            }
            return true;
        }
    }