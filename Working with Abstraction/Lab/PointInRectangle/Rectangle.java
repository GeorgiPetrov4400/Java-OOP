package WorkingWithAbstractionLab.PointInRectangle;

public class Rectangle {
    //    private int bottomCoordinateX;
    //    private int bottomCoordinateY;
    //    private int upperCoordinateX;
    //    private int upperCoordinateY;

    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(Point point) {
        boolean containsX = point.getCoordinateX() >= bottomLeft.getCoordinateX() &&
                point.getCoordinateX() <= topRight.getCoordinateX();

        boolean containsY = point.getCoordinateY() >= bottomLeft.getCoordinateY() &&
                point.getCoordinateY() <= topRight.getCoordinateY();

//        if (containsX && containsY) {
//            return true;
//        } else {
//            return false;
//        }

        return containsX && containsY;
    }
}
