public class Circle {
    int x;
    int y;
    double radius;
    String shapeConsoleOutput = "O";

    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 0.0;
        this.shapeConsoleOutput = "O";
    }
    public Circle(int nx, int ny) {
        this.x = nx;
        this.y = ny;
        this.radius = 0.0;
        this.shapeConsoleOutput = "O";
    }
    public Circle(int nx, int ny, double nradius) {
        this.x = nx;
        this.y = ny;
        this.radius = nradius;
        this.shapeConsoleOutput = "O";
    }

    public void draw() {
        System.out.println(shapeConsoleOutput);
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return (radius * radius);
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
    @Override
    public String toString() {
        return shapeConsoleOutput;
    }
}
