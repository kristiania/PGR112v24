package solutions.projects.commerce.warehouse.src;

public class Warehouse
{
    private final Store store;
    private final Inventory inventory;


    Warehouse(Store store) {
        this.store = store;
        this.inventory = new Inventory();
    }


    Store getStore() {
        return this.store;
    }


    Inventory getInventory() {
        return this.inventory;
    }
}
