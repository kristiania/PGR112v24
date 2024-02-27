package lectures._13.static_block.example;

public class Example
{
    static {
        System.out.println("Statisk kode-blokk");
    }

    public Example() {
        System.out.println("Konstruktøren");
    }

    public String getString() {
        return "%s".formatted(this.hashCode());
    }

    public static void main(String[] args) {
        Example object1 = new Example();
        Example object2 = new Example();

        System.out.println(object1.getString());
        System.out.println(object2.getString());

        if (object1 == object2) {
            System.out.println("Objektene er like");
        }
        else {
            System.out.println("Objektene er ikke like");
        }
    }
}
