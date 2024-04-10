package lectures._20.shop;

public class Product
{
    //# Fields
    private int id;
    private String name;
    private int price;


    //# Constructors
    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }
}
