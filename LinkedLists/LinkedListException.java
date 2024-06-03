public class LinkedListException extends Exception {
    /**
     * Default constructor of a new LinkedListException exception.
     */
    public LinkedListException() {
        super();
    }
    /**
     * Variable constructor of a new LinkedListException exception, containing a String message.
     * @param message String included in the composition of the new LinkedListException exception.
     */
    public LinkedListException(String message) {
        super(message);
    }
}
