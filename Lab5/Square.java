import java.awt.Graphics;

public class Square extends Shape {
    int sideLength;

    public Square(int a, int b) {
        super(a, b);
    }
    public Square(int a, int b, int sideLength) {
        super(a, b);
        this.setSideLength(sideLength);
    }

    public int getSideLength() {
        return sideLength;
    }
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return (double) (sideLength ^ 2);
    }
    @Override
    public void draw(Graphics g) {
        g.drawRect(getX(), getY(), sideLength, sideLength);
    }
}
