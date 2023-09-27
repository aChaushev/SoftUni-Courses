package _03_WorkingWith_Abstraction_Lab._02_PointInRectangle;

public class Rectangle {

    private Point bottomLeft;
    private Point topRight;


    public Rectangle(Point bottomLeft, Point tipRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = tipRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    // true -> ако дадената точка е вътре в правоъгълника
    // false -> ако е извън
    public boolean contains(Point point) {
        // вътре спрямо x
        boolean isInsideX = point.getX() >= bottomLeft.getX() && point.getX() <= topRight.getX();
        // вътре спрямо y
        boolean isInsideY = point.getY() >= bottomLeft.getY() && point.getY() <= topRight.getY();

        return isInsideX && isInsideY;
    }
}
