package lectures._13.static_block.example1;

import examples.data.Product;

import java.util.ArrayList;
import java.util.HashMap;


public class Store
{
    //# Static
    static HashMap<Long, Product> catalog = new HashMap<>();

    static {
        System.out.println("Static code block");
        ArrayList<Product> productList = new ArrayList<>();

        productList.add(new Product(7044610874913L, "Imsdal Sitron", 25));

        for (Product product : productList) {
            catalog.put(product.getCode(), product);
        }
    }

    static public boolean productExists(Store store, long code) {
        for (Product product : Store.catalog.values()) {
            if (product.getCode() == code) {
                return true;
            }
        }

        for (Product product : store.products.values()) {
            if (product.getCode() == code) {
                return true;
            }
        }

        return false;
    }


    //# Fields
    private HashMap<Long, Product> products = new HashMap<>();


    //# Constructor
    public Store() {
        System.out.println("Store constructor");
    }


    //# Getter-methods
    private HashMap<Long, Product> getProducts() {
        return this.products;
    }


    //# Methods
    public void createProduct(long code, String name, double price)
            throws StoreProductCodeAlreadyExists
    {
        if (!Store.productExists(this, code)) {
            Product product = new Product(code, name, price);

            this.products.put(product.getCode(), product);
        }
        else {
            throw new StoreProductCodeAlreadyExists(code);
        }
    }

    public Product getProduct(long code) {
        if (this.products.containsKey(code)) {
            return this.products.get(code);
        }

        if (Store.catalog.containsKey(code)) {
            return Store.catalog.get(code);
        }

        return null;
    }


    //# Static nested classes
    static public class StoreProductCodeAlreadyExists extends Exception {
        private StoreProductCodeAlreadyExists(long code) {
            super(STR."Product code already exists: \{code}");
        }
    }
}
