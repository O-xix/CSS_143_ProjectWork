/**
 * For Class Design - convert to IntList
 */
public class IntList {
    private int numElements = 0;
    private int[] data = new int[100]; // caps at 100 elements with no bullet-proofing or bounds checks, etc.

    /**
     * Adds item to this list without checking for array bounds.
     *
     * @param item value to add to the list
     */
    public void add(int item) {
        data[numElements++] = item;
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
            result.append(data[i]);
        }
        return result.toString();
    }

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

    public int sum() {
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            //can't do null for some reason; this is just to optimize performance in a way.
            if (!(data[i] == 0)) {
                sum += data[i];
            }
        }
        return sum;
    }

    public int indexOf(int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
