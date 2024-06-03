public class ColorWithAlpha extends SimpleColor {
    private int alpha;

    public ColorWithAlpha(int alpha) {
        this.setColor(0, 0, 0);
        this.alpha = alpha;
    }
    public ColorWithAlpha(int r, int g, int b, int alpha) {
        //Grabbing the super-class constructor.
        super(r, g, b);
        this.alpha = alpha;
    }
    public ColorWithAlpha(ColorWithAlpha that) {
        this(that.getR(), that.getG(), that.getB(), that.alpha);
    }
    public int getAlpha() {
        return alpha;
    }
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    @Override
    public String toString() { 
        return super.toString() + ", alpha: " + alpha;
    }
    @Override
    public boolean equals(Object o) {
        if (o instanceof ColorWithAlpha) {
            ColorWithAlpha that = new ColorWithAlpha((ColorWithAlpha) o);
            if (this.alpha == that.alpha && this.getR() == that.getR() && this.getG() == that.getG() && this.getB() == that.getB()) {
                return true;
            }
        }
        return false;
    }
}
