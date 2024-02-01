package solutions._07.classes;

public class SodaCan
{
    private String brand;
    private boolean open = false;

    public SodaCan(String brand) {
        this.brand = brand;
    }

    public boolean isOpened() {
        return this.open;
    }

    public void open() {
        this.open = true;
    }
}
