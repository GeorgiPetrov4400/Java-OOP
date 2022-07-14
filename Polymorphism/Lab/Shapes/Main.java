package PolymorphismLab.Shapes;

public class Main {
    public static void main(String[] args) {

        Shape rectangle = new Rectangle(4.5, 6.7);
        Shape circle = new Circle(8.9);

        System.out.println(rectangle.calculatePerimeter());
        System.out.println(rectangle.calculateArea());
        System.out.println(circle.calculatePerimeter());
        System.out.println(circle.calculateArea());

    }
}
