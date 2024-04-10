package lectures._20.shop;

import java.sql.SQLException;


public class Main
{
    public static void main(String[] args) throws SQLException {
        Store shop = new Store("Butikken på hjørnet");

        System.out.println(STR."Antall producter: \{shop.getProducts().size()}");
        System.out.println("---");

        for (int id : shop.getProducts().keySet()) {
            Product product = shop.getProducts().get(id);

            System.out.println(STR."Navn: \{product.getName()}");
            System.out.println(STR."Pris: \{product.getPrice()}");

            System.out.println("---");
        }
    }
}
