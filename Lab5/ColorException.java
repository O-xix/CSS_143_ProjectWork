public class ColorException extends RuntimeException {
    public ColorException() {
        super("An error occurred in Color");
    }
    public ColorException(String msg) {
        super(msg);
    }
    public static void main(String[] args) {
        throw new ColorException("A test in main");
    }
}