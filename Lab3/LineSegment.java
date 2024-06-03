public class LineSegment {
    //3.1: Class Constraints
    /*
     * The instance variables of a line segment are never null.
     * The start and end points of a line segment always have nonnegative coordinates (x, y >= 0).
     */

    //3.2: Data Fields
    //TODO: two Point2D variables for the start and end points
    private Point2D start;
    private Point2D end;

    //3.3: Constructors
    public LineSegment() {
        this.start = new Point2D();
        this.end = new Point2D();
    }
    public LineSegment(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }
    public LineSegment(LineSegment other) {
        this(other.start, other.end);
    }

    //3.4 & 3.5: Methods
    public Point2D getEnd() {
        return new Point2D(end);
    }
    public Point2D getStart() {
        return new Point2D(start);
    }
    public void setEnd(Point2D end) {
        this.end = end;
    }
    public void setStart(Point2D start) {
        this.start = start;
    }

    @Override
    public String toString() {
        //LineSegment [startPoint=Point2D [x=3, y=3], endPoint=Point2D [x=4, y=4]]
        return ("LineSegment [startPoint=Point2D " + start.toString() + ", endPoint=Point2D " + end.toString());
    }
    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof LineSegment))
            return false;
        LineSegment that = (LineSegment) other;
        if (this.start.equals(that.start) && this.end.equals(that.end)) {
            return true;
        }
        return false;
    }
    double getDistance() {
        return (Math.sqrt((double) (Math.pow(((this.getEnd().getX())-(this.getStart().getX())), 2) + Math.pow(((this.getEnd().getY())-(this.getStart().getY())), 2))));
    }

    //3.6: Questions:
    /*
     * What is a privacy leak?
     *  It's when data in memory that is not intended to manipulated or mutated becomes in that state.
     * Do your getters and setters have privacy leaks?
     *  No, because we set them equal to data in a new location in the program's memory, which they can give and allow for manipulation.
     * Where else could a privacy leak occur?
     *  Nowhere else in the class here, because it just doesn't have the access to more data that this class and its objects have.
     */
}    
