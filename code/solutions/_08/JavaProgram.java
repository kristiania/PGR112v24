package solutions._08;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


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
        System.out.printf("Informasjon om figur med id %d:%n".formatted(shape.getID()));
        System.out.println(shape);
        System.out.printf(" * Areal: %.2f%n".formatted(shape.getArea()));
        System.out.printf(" * Omkrets: %.2f%n".formatted(shape.getPerimeter()));

        // Ekstra oppgave 1
        JavaProgram.extraTask1(shapes);

        // Ekstra oppgave 2
        JavaProgram.extraTask2(shapes);
    }

    public static void extraTask1(HashMap<Integer, Shape> shapes) {
        for (Map.Entry<Integer, Shape> shape : shapes.entrySet()) {
            int key = shape.getKey();
            Shape value = shape.getValue();

            // Her er key = id
            // Her er value = figuren
        }
    }

    public static void extraTask2(HashMap<Integer, Shape> shapes) {
        double area = 50;

        System.out.println("---");
        System.out.println("Ekstra oppgave 2");
        System.out.println("Følgende figurer har areal over %.2f:".formatted(area));
        System.out.println("---");

        for (Shape shape : shapes.values()) {
            if (shape.getArea() >= area) {

                System.out.println(shape);
            }
        }
    }
}
