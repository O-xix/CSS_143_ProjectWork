/**
 * For Class Design - convert to IntList
 */
public class ObjectList {
    private int numElements = 0;
    private Object[] myShapes = new Object[100]; // caps at 100 elements with no bullet-proofing or bounds checks, etc.

    /**
     * Adds item to this list without checking for array bounds.
     *
     * @param shape value to add to the list
     */
    public void add(Object shape) {
        myShapes[numElements++] = shape;
    }

    /**
     * Returns a string representation of this list.
     *
     * @return a string representation of this list
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numElements; i++) {
            result.append(myShapes[i]);
        }
        return result.toString();
    }

    // main from lab goes here
    public static void main(String[] args) {
        IntList a = new IntList();
        a.add(95);
        a.add(100);
        a.add(58);
        System.out.println(a.toString() );
    //  System.out.println(a.sum() );
    //  System.out.println(a.indexOf(100));
        // Uncomment these to work on next
    //  System.out.println(a.indexOf(20));
    //  System.out.println(a.save());
    }
}
