//This is from the lab, though I don't know if this counts.
import java.awt.Graphics;

public class Circle extends Shape implements Cloneable {
    private int radius;
    /**
     * Constructor taking x and y values.
     * @param a x-value for reference point
     * @param b y-value for reference point
     */
    public Circle(int a, int b) {
        super(a, b);
    }
    /**
     * Overriden constructor with radius.
     * @param a x-value for reference point
     * @param b y-value for reference point
     * @param radius for the circle.
     */
    public Circle(int a, int b, int radius) {
        super(a, b);
        this.setRadius(radius);
    }

    /**
     * Getter method for radius.
     * @return interger representation of radius.
     */
    public int getRadius() {
        return radius;
    }
    /**
     * Setter method for radius.
     * @param radius Integer representation of radius to make this Circle.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public double getArea() {
        return Math.PI * (radius ^ 2);
    }
    @Override
    public void draw(Graphics g) {
        g.drawOval(getX(), getY(), getY(), getX());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Circle(this.getX(), this.getY(), this.getRadius());
    }
}
