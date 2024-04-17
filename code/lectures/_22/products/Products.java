package lectures._22.products;

import lectures._22.Database;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Products
{
    static private final Database database = new Database("files/lectures/22/database.properties");

    static private final Map<Integer, Product> data = new HashMap<>();

    static {
        try (var connection = database.getConnection()) {

            var statement = connection.createStatement();

            var result = statement.executeQuery("SELECT * FROM product;");

            while (result.next()) {
                var product = new Product(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("description"),
                        result.getInt("price")
                );

                Products.data.put(product.id(), product);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(STR."Loaded \{Products.data.size()} products from the database");
    }


    static void loadProductsFromFileIntoDatabase() throws SQLException, FileNotFoundException {
        var filePath = "files/lectures/22/products.txt";
        var file = new File(filePath);
        var input = new Scanner(file);

        var products = new HashMap<String, Integer>();

        while (input.hasNextLine()) {
            var line = input.nextLine();

            if (line.startsWith("#")) {
                continue;
            }

            var data = line.split(",");

            String name = data[0];
            int price = Integer.parseInt(data[1]);

            products.put(name, price);
        }

        for (var entry : products.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("---");
        }

        var connection = Products.database.getConnection();

        String query = "INSERT INTO product(name, price) VALUES (?, ?);";

        for (var entry : products.entrySet()) {
            var name = entry.getKey();
            var price = entry.getValue();

            if (Products.productIsCached(name, price)) {
                continue;
            }

            var statement = connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setInt(2, price);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println(STR."Produktet \"\{name}\" ble lagt til i databasen med følgende pris: \{price}");
            }
            else {
                System.out.println(STR."Produkt ikke lagt til i databasen: \{name}");
            }
        }

        connection.close();
    }


    static boolean productIsCached(String name, int price) {
        for (var product : Products.data.values()) {
            if (product.name().equals(name) && product.price() == price) {
                return true;
            }
        }

        return false;
    }
}
