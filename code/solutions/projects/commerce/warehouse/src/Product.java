package solutions.projects.commerce.warehouse.src;

public class Product
{
    //# Fields
    private String name;
    private double price;


    //# Constructors
    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }


    //# Getter-methods
    String getName() {
        return this.name;
    }

    double getPrice() {
        return this.price;
    }
}
