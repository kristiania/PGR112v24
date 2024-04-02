package solutions.projects.commerce.warehouse.src;

public class Main
{
    public static void main(String[] args) {
        Store store = new Store();

        //# Opprett mange forskjellige produkter
        Product apple = new Product("Eple", 7.50);
        Product banana = new Product("Banan", 9.20);
        Product pear = new Product("Pære", 8.45);

        // og legg de til i lageret
        store.getWarehouseInventory().addProduct(apple, 100);
        store.getWarehouseInventory().addProduct(banana, 100);
        store.getWarehouseInventory().addProduct(pear, 100);

        //# Flytt varer fra lageret til butikken
        store.moveProduct(apple, 50);
        store.moveProduct(banana, 40);
        store.moveProduct(pear, 20);

        // Print ut varehusets verdi
        System.out.printf("Warehouse worth: kr %.2f,-%n", store.totalWarehouseValue());

        // Print ut butikkens verdi
        System.out.printf("Store worth: kr %.2f,-%n", store.totalStoreValue());

        // Print ut samlet verdi
        System.out.println();
        System.out.printf("Total worth: kr %.2f,-%n", store.totalValue());
    }
}
