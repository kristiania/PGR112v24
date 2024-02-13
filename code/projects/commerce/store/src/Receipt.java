package projects.commerce.store.src;

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
        return 0; // TODO
    }

    int totalProducts() {
        return 0; // TODO
    }
}
