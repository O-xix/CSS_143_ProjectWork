//Seems like it works, but I can't say it's nice.
import java.awt.Graphics;

public class FractalFlake extends Shape {
    //a. Define a private final int to manage the snowflake’s limit. These should be values such as {1..50}
    private final int snowflakeLimit;
    public int getSnowflakeLimit() {
        return snowflakeLimit;
    }

    //b. Define a second private final int to manage the number of branches for the flake. These should be between {5..12}
    private final int numBranchesFlake;
    public int getNumBranchesFlake() {
        return numBranchesFlake;
    }

    //3. Build a suitable constructor for FractalFlake that invokes the superclass constructor as the first line of code.
    public FractalFlake(int a, int b) {
        super(a, b);
        this.snowflakeLimit = 1;
        this.numBranchesFlake = 5;
        //TODO Auto-generated constructor stub
    }

    public FractalFlake(int a, int b, int size) {
        super(a, b);
        this.numBranchesFlake = size;
        this.snowflakeLimit = 1;
    }

    //b. Our FractalFlake also has a branching factor, which should be handed to the constructor for our class to manage.
    public FractalFlake(int a, int b, int size, int numBranchesFlake) {
        super(a, b);
        this.numBranchesFlake = numBranchesFlake;
        this.snowflakeLimit = size;
    }

    //4. Override the draw function so that it invokes a second draw function that takes more parameters than just the Graphics object, as in:
    @Override
    public void draw(Graphics g) { // a redirect or facade
        draw(g, getX(), getY(), getSnowflakeLimit());
    }

    //5. Overload the draw function by defining a new draw function that takes a starting (x, y) coordinate pair, a limit, and a graphics object to render to, as in:
    private void draw(Graphics g, int startX, int startY, int limit) {
        if (limit >= 3) {
            for (int i = 0; i < getNumBranchesFlake(); i++) {
                int x2 = startX + (int) (limit * Math.cos((2 * Math.PI / getNumBranchesFlake()) * i));
                int y2 = startY - (int) (limit * Math.sin((2 * Math.PI / getNumBranchesFlake()) * i));
                g.drawLine(startX, startY, x2, y2);
                draw(g, x2, y2, limit/3);
            }
        }
    }
}