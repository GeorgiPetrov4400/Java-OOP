package WorkingWithAbstractionLab.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rectangleCoordinates = getRectangleCoordinates(scanner);

        int rectangleBottomX = rectangleCoordinates[0];
        int rectangleBottomY = rectangleCoordinates[1];
        Point bottomLeft = new Point(rectangleBottomX, rectangleBottomY);

        int rectangleUpperX = rectangleCoordinates[2];
        int rectangleUpperY = rectangleCoordinates[3];
        Point topRight = new Point(rectangleUpperX, rectangleUpperY);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            int[] pointCoordinates = getRectangleCoordinates(scanner);

            int pointCoordinateX = pointCoordinates[0];
            int pointCoordinateY = pointCoordinates[1];

            Point currentPoint = new Point(pointCoordinateX, pointCoordinateY);
            System.out.println(rectangle.contains(currentPoint));

        }
    }

    private static int[] getRectangleCoordinates(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
    }
}
