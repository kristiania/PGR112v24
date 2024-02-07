package solutions._07.example2;

import java.util.HashMap;
import java.util.Iterator;

public class ShoppingCart implements Iterable<Product>
{
    // produkt og antall av produktet
    private HashMap<Product, Integer> data;

    public ShoppingCart() {
        this.data = new HashMap<>();
    }

    private boolean productExistsInCart(Product product) {
        return this.data.containsKey(product);
    }

    public void addProduct(Product product) {
        if (this.productExistsInCart(product)) {
            this.data.put(product, this.data.get(product) + 1);
        }
        else {
            this.data.put(product, 1);
        }
    }

    public void removeProduct(Product product) {
        if (this.productExistsInCart(product)) {
            int quantity = this.data.get(product);

            if (quantity >= 1) {
                if (quantity == 1) {
                    this.data.remove(product);
                }
                else {
                    this.data.put(product, quantity - 1);
                }
            }
        }
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    public boolean containsProducts() {
        return !this.isEmpty();
    }

    public int getProductQuantity(Product product) {
        return this.data.get(product);
    }

    public double totalPrice() {
        double price = 0;

        for (Product product : this.data.keySet()) {
            price += product.getPrice()*this.data.get(product);
        }

        return price;
     }

    @Override
    public Iterator<Product> iterator() {
        return this.data.keySet().iterator();
    }
}
