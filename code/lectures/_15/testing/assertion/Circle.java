package lectures._15.testing.assertion;

public class Circle
{
    private int[] position = { 0, 0 };
    private float radius;

    public Circle(int x, int y, float radius) {
        // Positive values only
        assert x >= 0 : "X-value must be a non-negative number";
        assert y >= 0 : "Y-value msut be a non-negative number";
        assert radius >= 0 : "Radius-value must be a non-negative number";

        // Construct circle knowing that all values are positive
        this.position[0] = x;
        this.position[1] = y;

        this.radius = radius;
    }

    // Her har vi en Main-metode kun for å slippe å ha en egen klasse for å teste
    // opprettelsen av en instans av klassen Circle her - vanlig praksis er å ha en
    // egen klasse men en statisk main-metode som fungerer som utgangspunktet for programmene våre
    public static void main(String[] args) {
        Circle circle1 = new Circle(-1, -1, -1);
    }
}
