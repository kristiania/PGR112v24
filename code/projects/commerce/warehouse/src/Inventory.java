package projects.commerce.warehouse.src;

import java.util.HashMap;


public class Inventory
{
    HashMap<Product, Integer> products = new HashMap<>();

    double valueOfProducts() {
        // TODO regn ut verdien av alle produktene
        return 0;
    }

    int amountOfProducts() {
        // TODO regn ut antall produkter lagret
        return 0;
    }

    void addProduct(Product product, int quantity) {
        // TODO
    }

    void removeProduct(Product product, int quantity) {
        // TODO
    }
}
