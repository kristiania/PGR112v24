package solutions.projects.commerce.warehouse.src;

public class Store
{
    private final Warehouse warehouse;
    private final Inventory inventory = new Inventory();


    Store() {
        this.warehouse = new Warehouse(this);
    }

    private Warehouse getWarehouse() {
        return this.warehouse;
    }

    Inventory getWarehouseInventory() {
        return this.getWarehouse().getInventory();
    }


    void moveProduct(Product product, int quantity) {
        if (this.warehouse.getInventory().products.containsKey(product)) {
            int stock = this.warehouse.getInventory().products.get(product);

            if (stock >= quantity) {
                this.warehouse.getInventory().removeProduct(product, quantity);
                this.inventory.addProduct(product, quantity);
            }
        }
    }


    double totalWarehouseValue() {
        return this.warehouse.getInventory().valueOfProducts();
    }

    double totalStoreValue() {
        return this.inventory.valueOfProducts();
    }


    double totalValue() {
        return this.totalWarehouseValue() + this.totalStoreValue();
    }
}
