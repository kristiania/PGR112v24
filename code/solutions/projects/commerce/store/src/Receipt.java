package solutions.projects.commerce.store.src;

import java.util.HashMap;


public class Receipt
{
    //# Fields
    private final HashMap<Product, Integer> products;


    //# Constructors
    Receipt(HashMap<Product, Integer> products) {
        this.products = products;
    }


    //# Getter-methods
    HashMap<Product, Integer> getProducts() {
        return this.products;
    }


    //# Methods
    int totalPrice() {
        int total = 0;

        for (Product product : this.getProducts().keySet()) {
            total += product.getPrice()*this.getProducts().get(product);
        }

        return total;
    }

    int totalProducts() {
        int total = 0;

        for (int quantity : this.getProducts().values()) {
            total += quantity;
        }

        return total;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        for (Product product : this.getProducts().keySet()) {
            string.append(STR."\{product.getName()} x\{this.getProducts().get(product)}; ");
        }

        return "Receipt[%s] = kr %d,-".formatted(
                string.toString().trim(),
                this.totalPrice()
        );
    }
}
