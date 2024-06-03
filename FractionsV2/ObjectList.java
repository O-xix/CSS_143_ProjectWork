/**
 * For Class Design - convert to IntList
 */
public class ObjectList {
    private int numElements = 0;
    //I also know it wants any size, however I thought to try and keep it to the class definition from the lab as much as possible (though, I know I clearly broke that). It's probably expected to change this to a ArrayList, which can be done with no difficulty.
    FractionCounter[] myObjects = new FractionCounter[100]; // caps at 100 elements with no bullet-proofing or bounds checks, etc.

    /**
     * Adds item to this list without checking for array bounds.
     *
     * @param object value to add to the list
     */
    public void add(FractionCounter object) {
        myObjects[numElements++] = object;
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
            result.append(myObjects[i]);
        }
        return result.toString();
    }

    /*
    // main from lab goes here
    public static void main(String[] args) {
        ObjectList a = new ObjectList();
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
    */
}
