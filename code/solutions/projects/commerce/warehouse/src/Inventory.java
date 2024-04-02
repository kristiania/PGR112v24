package solutions.projects.commerce.warehouse.src;

import java.util.HashMap;


public class Inventory
{
    HashMap<Product, Integer> products = new HashMap<>();

    double valueOfProducts() {
        double total = 0;

        for (Product product : this.products.keySet()) {
            total += product.getPrice()*this.products.get(product);
        }

        return total;
    }

    int amountOfProducts() {
        int total = 0;

        for (int quantity : this.products.values()) {
            total += quantity;
        }

        return total;
    }

    void addProduct(Product product, int quantity) {
        if (this.products.containsKey(product)) {
            this.products.put(product, this.products.get(product) + quantity);
        }
        else {
            this.products.put(product, quantity);
        }
    }

    void removeProduct(Product product, int quantity) {
        if (this.products.containsKey(product)) {
            if (this.products.get(product) >= quantity) {
                this.products.put(product, this.products.get(product) - quantity);
            }
        }
    }
}
