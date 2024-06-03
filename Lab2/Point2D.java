public class Point2D {
    private int x;
    private int y;

    /*
     * What effect does private have for methods trying to use x or y inside this class file?
     *      - It grabs from the instance?
        What about methods trying to use x and y outside this class?
            - Again, it can only grab x and y from an instance, because the class's variable x and y are private.
        Can you use x and y without an associated object (or instance)?
            - Yes, inside the class. Otherwise, no.
     */
    public static void main(String[] args) {
        Point2D a = new Point2D();
        a.setX(5);
        a.setY(2);
        System.out.println("Point at (" + a.getX() + ", " + a.getY()); 
        a.translate(-1,-1);
        System.out.println("Point at (" + a.getX() + ", " + a.getY());
        a.resetToOrigin();
        System.out.println("Point at (" + a.getX() + ", " + a.getY()); 
        Point2D b = new Point2D();
        Point2D c = new Point2D();
        System.out.println(b.toString());
        System.out.println(c); // Question: Why don’t you need c.toString() here?
        System.out.println("Are b and c equal:" + b.equals(c));
    }

    public void setX(int nX) {
        this.x = nX;
    }
    public void setY(int nY) {
        this.y = nY;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void resetToOrigin() {
        x = 0;
        y = 0;
    }
    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }
    @Override
    public String toString() {
        return ("(" + x + ", " + "y");
    }
    // @Override not used here on purpose 
    public boolean equals(Point2D that) { 
        // returns true if this is equal to that
        // don’t just use “this == that”
        if (that.x == this.x && that.y == this.y) {
            return true;
        }
        return false;
    }
}
