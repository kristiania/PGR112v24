package lectures._19;

import java.sql.SQLException;

public class TwoDatabasesExample
{
    public static void main(String[] args) {
        var database1 = new Database("files/lectures/19/database.properties");
        var database2 = new Database("files/lectures/19/lecture18.properties");

        try {
            var lecture19 = database1.getConnection();
            var lecture18 = database2.getConnection();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
