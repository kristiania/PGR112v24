package lectures._10;

public class MethodOverloading
{
    private final int number = 123;

    public MethodOverloading() {
        System.out.println("Ingen parametere");
    }

    public MethodOverloading(String input) {
        System.out.println("Ét parameter");
    }

    public void sayNumber(int number) {

    }

    public void sayNumber(double number) {

    }

    public void sayNumber(float number) {

    }

    public void sayNumber(long number) {

    }

    public void sayNumber(short number) {

    }

    public static void main(String[] args) {
        MethodOverloading M1 = new MethodOverloading();
        MethodOverloading M2 = new MethodOverloading("text");


        M1.sayNumber(123);
    }
}
