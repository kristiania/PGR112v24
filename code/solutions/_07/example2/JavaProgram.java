package solutions._07.example2;

public class JavaProgram
{
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product apple = new Product("Apple", 5.20);
        Product banana = new Product("Banana", 7.50);

        DiscountedProduct oldBanana = new DiscountedProduct("Old Banana", 2.35, 50);

        int apples = 5;
        int bananas = 3;

        for (int i = 0; i < apples; i ++) {
            cart.addProduct(apple);
        }

        for (int i = 0; i < bananas; i ++) {
            cart.addProduct(banana);
        }

        cart.addProduct(oldBanana);
        cart.addProduct(oldBanana);
        cart.addProduct(oldBanana);

        System.out.printf("Total prisen er kr %.2f,-%n".formatted(
                cart.totalPrice()
        ));

        int discountedProducts = 0;

        for (Product product : cart) {
            if (product instanceof DiscountedProduct) {
                discountedProducts += cart.getProductQuantity(product);
            }
        }

        System.out.println("Antall rabatterte produkter: " + discountedProducts);
    }
}
