package solutions._09;

import java.util.ArrayList;

public class TestShapes
{
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        shapes.add(new Circle(4.0, new MovablePoint(10.0, 10.0)));

        shapes.add(
                new Rectangle(
                        3.0,
                        4.0,
                        new MovablePoint(40.0, 40.0),
                        new MovablePoint(43.0, 44.0)
                )
        );

        shapes.add(new Square(10.0));

        System.out.println("Figurene før vi har flyttet de 10.0 til høyre:");

        for (Shape shape : shapes) {
            System.out.println(" - " + shape);
        }

        System.out.println();

        System.out.println("Figurene etter vi har flyttet de 10.0 til høyre:");

        for (Shape shape : shapes) {
            shape.moveRight(10.0);

            System.out.println(" - " + shape);
        }
    }
}