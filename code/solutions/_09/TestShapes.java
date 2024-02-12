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


        //# Oppgave 08
        // Her gjenbruker vi "shapes" ArrayList-en ved å klarere den:
        shapes.clear();

        Shape shape01 = new Circle();
        Shape shape02 = new Rectangle();
        Shape shape03 = new Square();

        shapes.add(shape01);
        shapes.add(shape02);
        shapes.add(shape03);

        for (Shape shape : shapes) {
            System.out.println("---");
            System.out.printf("Shape #%d".formatted(shape.getID()));
            System.out.printf("Areal: %.2f".formatted(shape.getArea()));
            System.out.printf("Omkrets: %.2f".formatted(shape.getPerimeter()));

            if (shape instanceof Circle) {
                ((Circle) shape).uniqueCircleMethod();
            }
            else if (shape instanceof Square) {
                ((Square) shape).uniqueSquareMethod();
            }
            else if (shape instanceof Rectangle) {
                ((Rectangle) shape).uniqueRectangleMethod();
            }
        }
    }
}