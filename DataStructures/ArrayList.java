public class ArrayList {
    //All methods have been commented.
    Object[] arrListObjects;

    /**
     * Blank constructor.
     */
    public ArrayList() {
        this.arrListObjects = new Object[0];
    }
    /**
     * Copy constructor.
     * @param otherArrayList Uses another ArrayList as a parameter.
     */
    public ArrayList(ArrayList otherArrayList) {
        this.arrListObjects = otherArrayList.arrListObjects.clone();
    }

    /**
     * Adds the object at the end of the ArrayList-like structure.
     * @param objectToAdd
     */
    void add(Object objectToAdd) {
        Object[] temp = new Object[arrListObjects.length + 1];
        System.arraycopy(arrListObjects, 0, temp, 0, arrListObjects.length);
        temp[temp.length - 1] = objectToAdd;
        arrListObjects = null;
        arrListObjects = temp;
    }
    /**
     * Add the object at the specified index.
     * @param objectToInsert Object to insert.
     * @param index int representation of the index the object is to be added at.
     */
    void insert(Object objectToInsert, int index) {
        Object[] temp = new Object[arrListObjects.length + 1];
        System.arraycopy(arrListObjects, 0, temp, 0, index);
        System.arraycopy(arrListObjects, index, temp, index+1, arrListObjects.length-index);
        temp[index] = objectToInsert;
        arrListObjects = null;
        arrListObjects = temp;
    }
    /**
     * Remove and return the object at the specified index. (This should behave like the corresponding method in Java's built-in ArrayList class; see Savitch's description.)
     * @param index
     * @return
     */
    Object remove(int index) {
        Object[] temp = new Object[arrListObjects.length - 1];
        Object removedObject = arrListObjects[index];
        System.arraycopy(arrListObjects, 0, temp, 0, index);
        System.arraycopy(arrListObjects, index+1, temp, index, arrListObjects.length-(index+1));
        arrListObjects = null;
        arrListObjects = temp;
        return removedObject;
    }
    /**
     * 
     * @return Integer representation of the size of arrListObjects
     */
    int size() {
        return arrListObjects.length;
    }
    /**
     * Parses and formats queueObjects to a String.
     * @return String representation of Queue.
     */
    public String toString() {
        String tempString = ("[");
        for (int i = 0; i < arrListObjects.length-1; i++) {
            tempString = tempString + arrListObjects[i] + ", ";
        }
        tempString = tempString + arrListObjects[arrListObjects.length-1] + "]";
        return tempString;
    }
    /**
     * Checks if arrListObjects has a size of zero, making it empty.
     * @return Boolean representation of the value of the arrListObjects.
     */
    boolean isEmpty() {
        if (arrListObjects.length == 0)
            return true;
        return false;
    }
    /**
     * Returns -1 if not found.
     * @param objectToFind
     * @return Integer representation of the index.
     */
    int indexOf(Object objectToFind) {
        for (int i = 0; i < arrListObjects.length; i++) {
            if (arrListObjects[i].equals(objectToFind)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Compare sizes and elements in the data structure.
     * @param that 
     * @return
     */
    public boolean equals(Object object) {
        if ((object != null) && (object instanceof ArrayList)) {
            ArrayList that = (ArrayList) object;
            if ((that.arrListObjects.equals(this.arrListObjects))) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns the object at index specified.
     * @param index
     * @return
     */
    Object get(int index) {
        return arrListObjects[index];
    }
}
