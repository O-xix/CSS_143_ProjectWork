import java.awt.*;

public class Shape {
    /*
     * 1.1:
     * x and y do not have to be nonnegative, because the origin (0, 0) could be the center screen
     * Length and width, or radius does have to be nonnegative, because it isn't necessary.
     */
    
    //1.2: Data fields
    private int x;
    private int y;
    private Color color;

    //1.3: Constructors
    /**
     * A constructor with no parameters. You can choose what values the fields should have by default.
     */
    public Shape() {
        this.x = 0;
        this.y = 0;
        this.color = Color.WHITE;
    }
    /**
     * A constructor with parameters for the x and y coordinates and the color.
     * @param x Integer representing x-coordinate
     * @param y Integer representing y-coordinate
     * @param color Color value representing color of shape
     */
    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public Shape(Shape other) {
        this(other.x, other.y, other.color);
    }

    //1.4: Instance Methods
    public Color getColor() {
        return color;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        // Shape (10,140) and color:java.awt.Color[r=64,g=64,b=64] and area: -1
        return ("Shape (" + x + ", " + y + ") and color:" + color.toString() + " and area: -1");
    }
    public double getArea() {
        return -1.0;
    }
    public void draw(Graphics g) {

    }



}
