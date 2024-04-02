package lectures._17;

public class Static
{
    public void methodNonStatic() {
        System.out.println("non-static");
    }

    public static void methodStatic() {
        System.out.println("static");
    }

    public static void main(String[] args) {
        Static.methodStatic();

        Static object1 = new Static();
        Static object2 = new Static();

        object1.methodNonStatic();
        object2.methodNonStatic();

        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());


        object1.methodStatic();
        object2.methodStatic();
    }
}
