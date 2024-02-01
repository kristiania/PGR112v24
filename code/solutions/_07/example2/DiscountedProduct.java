package solutions._07.example2;

public class DiscountedProduct extends Product
{
    private static int standardDiscount = 10;
    private int discount;

    public DiscountedProduct(String name, double value) {
        this(name, value, DiscountedProduct.standardDiscount);
    }

    public DiscountedProduct(String name, double price, int discount) {
        super(name, price);

        this.setDiscount(discount);
    }

    public int getDiscount() {
        return this.discount;
    }

    public void setDiscount(int value) {
        this.discount = value;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();

        return price - (price/100)*this.getDiscount();
    }
}
