public class Square {
    int x;
    int y;
    double sideLength;
    String shapeConsoleOutput = "[]";

    public Square() {
        this.x = 0;
        this.y = 0;
        this.sideLength = 0.0;
        this.shapeConsoleOutput = "[]";
    }
    public Square(int nx, int ny) {
        this.x = nx;
        this.y = ny;
        this.sideLength = 0.0;
        this.shapeConsoleOutput = "[]";
    }
    public Square(int nx, int ny, double nsideLength) {
        this.x = nx;
        this.y = ny;
        this.sideLength = nsideLength;
        this.shapeConsoleOutput = "[]";
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
    public double getSideLength() {
        return sideLength;
    }
    public double getArea() {
        return (sideLength * sideLength);
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
    @Override
    public String toString() {
        return shapeConsoleOutput;
    }
}
