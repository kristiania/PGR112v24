package examples.data;

import java.util.Comparator;

public class Product
{
    //# Static
    static private int id = 0;


    //# Fields
    /** Produktets id-nummer */
    private final int number;
    /** Strek-kode */
    private long code;
    private String name;
    private double price;


    //# Constructors
    public Product(long code, String name, double price) {
        this.number = Product.id ++;

        this.setCode(code);
        this.setName(name);
        this.setPrice(price);
    }

    //# Getter-methods
    public int getId() {
        return this.number;
    }

    public long getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }


    //# Setter-methods
    private void setCode(long value) {
        this.code = value;
    }

    public void setName(String value) {
        this.name = value;
    }

    public void setPrice(double value) {
        this.price = value;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Product product) {
            if (product.getId() == this.getId()) {
                return true;
            }

            return product.getCode() == this.getCode();
        }

        return false;
    }
}
