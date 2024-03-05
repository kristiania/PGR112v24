package lectures._15.generic;

public class Main
{
    public static void main(String[] args) {
        Example2<Integer> example = new Example2<>(123);

        int number = example.getObject();

    }
}
