import java.awt.Graphics;

public class Circle extends Shape {
    private int radius;

    public Circle(int a, int b) {
        super(a, b);
    }
    public Circle(int a, int b, int radius) {
        super(a, b);
        this.setRadius(radius);
    }

    public int getRadius() {
        return radius;
    }
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
}
