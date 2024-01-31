package lectures._03;

public class LightBulb {
    //# Fields
    private boolean on = false;

    //# Constructor
    LightBulb() {

    }

    //# Method
    public boolean toggle() {
        this.on = !this.on;

        return this.on;
    }
}
