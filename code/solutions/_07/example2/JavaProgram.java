package solutions._07.example2;

public class JavaProgram
{
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product apple = new Product("Apple", 5.20);
        Product banana = new Product("Banana", 7.50);

        int apples = 5;
        int bananas = 3;

        for (int i = 0; i < apples; i ++) {
            cart.addProduct(apple);
        }

        for (int i = 0; i < bananas; i ++) {
            cart.addProduct(banana);
        }

        System.out.printf("Total prisen for %d epler og %d bananer er kr %.2f,-".formatted(
                apples,
                bananas,
                cart.totalPrice()
        ));
    }
}
