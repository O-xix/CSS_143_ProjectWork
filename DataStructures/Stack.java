public class Stack {
    //All methods have been commented.
    Object[] stackObjects = new Object[0];

    /**
     * Blank constructor.
     */
    public Stack() {
        this.stackObjects = new Object[0];
    }

    /**
     * Copy constructor.
     * @param otherStack Uses another Stack as a parameter.
     */
    public Stack(Stack otherStack) {
        this.stackObjects = otherStack.stackObjects.clone();
    }
    /**
     * Reformats stackObjects, and adds an object to the front of stackObjects.
     * @return
     */
    void push(Object pushedObject) {
        Object[] temp = new Object[stackObjects.length + 1];
        System.arraycopy(stackObjects, 0, temp, 1, stackObjects.length);
        temp[0] = pushedObject;
        stackObjects = null;
        stackObjects = temp;
    }
    /**
     * Reformats stackObjects, and removes and returns an Object from the front of stackObjects.
     * @return Object from front of stackObjects.
     */
    Object pop() {
        Object[] temp = new Object[stackObjects.length - 1];
        Object poppedObject = stackObjects[0];
        System.arraycopy(stackObjects, 1, temp, 0, stackObjects.length - 1);
        stackObjects = null;
        stackObjects = temp;
        return poppedObject;
    }
    /**
     * "A classic stack does not have a size method, but in this assignment we are asking you to implement one."
     * @return Integer representation of the size.
     */
    int size() {
        return stackObjects.length;
    }
    
    /**
     * Parses and formats stackObjects to a String.
     * @return String representation of Stack.
     */
    public String toString() {
        String tempString = ("[");
        for (int i = 0; i < stackObjects.length-1; i++) {
            tempString = tempString + stackObjects[i] + ", ";
        }
        tempString = tempString + stackObjects[stackObjects.length-1] + "]";
        return tempString; 
    }
    boolean isEmpty() {
        if (stackObjects.length == 0)
            return true;
        return false;
    }
    /**
     * Checks the value equivalency of this Stack and another Object.
     * @param object Object that is been equivated.
     * @return
     */
    public boolean equals(Object object) {
        if ((object != null) && (object instanceof Stack)) {
            Stack that = (Stack) object;
            if ((that.stackObjects.equals(this.stackObjects))) {
                return true;
            }
        }
        return false;
    }
}
