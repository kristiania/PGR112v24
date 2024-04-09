package lectures._19;

public class StaticCodeBlockExample
{
    static {
        System.out.println("STATIC CODE BLOCK");
    }

    {
        System.out.println("NON-STATIC CODE BLOCK");
    }

    public static void main(String[] args) {
        StaticCodeBlockExample object1 = new StaticCodeBlockExample();
        StaticCodeBlockExample object2 = new StaticCodeBlockExample();
    }
}
