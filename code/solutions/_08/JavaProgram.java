package solutions._08;

import java.util.ArrayList;
import java.util.HashMap;

public class JavaProgram
{
    public static void main(String[] args) {
        ArrayList<Shape> list = new ArrayList<>();

        list.add(new Circle(10));
        list.add(new Rectangle(12, 9));
        list.add(new Square(42));
        list.add(new Circle(50));
        list.add(new Circle(10)); // id=4
        list.add(new Square(2));
        list.add(new Rectangle(4, 4));
        list.add(new Square(8));
        list.add(new Circle(24));
        list.add(new Square(9));

        HashMap<Integer, Shape> shapes = new HashMap<>();

        for (Shape shape : list) {
            shapes.put(shape.getID(), shape);
        }

        for (Shape shape : shapes.values()) {
            System.out.println(shape);
        }


        Shape shape = shapes.get(4);

        System.out.println("---");
        System.out.printf("Informasjon om figur med id %d:".formatted(shape.getID()));
        System.out.println(shape);
        System.out.printf(" * Areal: %.2f%n".formatted(shape.getArea()));
        System.out.printf(" * Omkrets: %.2f%n".formatted(shape.getPerimeter()));
    }
}
