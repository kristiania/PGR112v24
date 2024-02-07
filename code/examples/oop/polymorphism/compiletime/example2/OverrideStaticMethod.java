package examples.oop.polymorphism.compiletime.example2;

public class OverrideStaticMethod extends SuperClass
{
    public static void methodA() {
        System.out.println("OverrideStaticMethod.method()");
    }

    public static void main(String[] args) {
        methodA();
        methodB();

        // Her vises hvorfor det kan være greit
        // at vi alltid bruker navnet på klassen
        // når vi refererer til statiske metoder
        // og felter
    }
}
