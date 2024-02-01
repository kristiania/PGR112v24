package solutions._07.example2;

public class Product
{
    private String name;
    private double price;

    public Product(String name, double price) {
        this.setName(name);
        this.setPrice(price);
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    private void setName(String value) {
        this.name = value;
    }

    protected void setPrice(double value) {
        this.price = value;
    }
}
