package lectures._22.products;

public class Main
{
    public static void main(String[] args) {
        var prodcuts = new Products();

        try {
            Products.loadProductsFromFileIntoDatabase();


        } catch (Exception e) {
            System.out.println("Det oppstod en exceptiion, pls fix ur code!");

            throw new RuntimeException(e);
        }
    }
}
