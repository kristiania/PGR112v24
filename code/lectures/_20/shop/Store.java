package lectures._20.shop;

import lectures._20.Database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class Store
{
    private static final Database database = new Database(
            "files/lectures/20/database.properties"
    );


    //# Fields
    private String name;
    private final HashMap<Integer, Product> products = new HashMap<>();


    //# Constructors
    public Store(String name) throws SQLException {
        this.name = name;

        this.getProductsFromDatabase();
    }


    //# Getter-methods
    HashMap<Integer, Product> getProducts() {
        return this.products;
    }

    //# Methods
    private void getProductsFromDatabase() throws SQLException{
        var connection = Store.database.getConnection();

        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery(
                "SELECT * FROM product;"
        );

        while (result.next()) {
            this.products.put(result.getInt("id"), new Product(
                    result.getInt("id"),
                    result.getString("name"),
                    result.getInt("price")
            ));
        }
    }
}
