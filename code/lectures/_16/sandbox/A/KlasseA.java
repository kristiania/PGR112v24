package lectures._16.sandbox.A;

public class KlasseA {
    String name = "Klasse B";

    private String privateData = "PRIVATE";
    protected String protectedData = "PROTECTED";

    String packageData = "PACKAGE";



    public void method() {
        System.out.println(this.hashCode());
    }

    public static void printInfo() {
        System.out.println("Static method in KlasseC");
    }
}
