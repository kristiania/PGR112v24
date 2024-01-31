package lectures._07.aggregation;


public class Liquid
{
    //# Fields
    private final String name;
    private double volume; // liter


    //# Constructors
    public Liquid(String name) {
        this(name, 1.0);
    }

    public Liquid(String name, double volume) {
        this.name = name;
        this.volume = volume;
    }


    //# Getter-methods
    public String getName() {
        return this.name;
    }

    public double getVolume() {
        return this.volume;
    }


    //# Setter-methods
    protected void setVolume(double value) {
        this.volume = value;
    }


    //# Methods
    public boolean merge(Liquid liquid) {
        if (this.getName().equals(liquid.getName())) {
            this.setVolume(this.getVolume() + liquid.getVolume());

            return true;
        }

        return false;
    }
}