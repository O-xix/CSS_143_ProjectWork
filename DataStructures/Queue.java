public class Queue {
    //All methods have been commented.
    Object[] queueObjects = new Object[0];;

    /**
     * Blank constructor.
     */
    public Queue() {
        this.queueObjects = new Object[0];
    }

    /**
     * Copy constructor.
     * @param otherQueue Uses another Queue as a parameter.
     */
    public Queue(Queue otherQueue) {
        this.queueObjects = otherQueue.queueObjects.clone();
    }

    /**
     * Reformats queueObjects, and adds an object to the front of queueObjects.
     * @return
     */
    void enqueue(Object objectToEnqueue) {
        Object[] temp = new Object[queueObjects.length + 1];
        System.arraycopy(queueObjects, 0, temp, 1, queueObjects.length);
        temp[0] = objectToEnqueue;
        queueObjects = null;
        queueObjects = temp;
    }
    
    /**
     * Reformats queueObjects, and removes and returns an Object from the back of queueObjects.
     * @return Object from back of queueObjects.
     */
    Object dequeue() {
        Object[] temp = new Object[queueObjects.length - 1];
        Object poppedObject = queueObjects[queueObjects.length - 1];
        System.arraycopy(queueObjects, 0, temp, 0, queueObjects.length - 1);
        queueObjects = null;
        queueObjects = temp;
        return poppedObject;
    }
    /**
     * "A classic queue does not have a size method, but in this assignment we are asking you to implement one."
     * @return Integer representation of the size.
     */
    int size() {
        return queueObjects.length;
    }
    /**
     * Parses and formats queueObjects to a String.
     * @return String representation of Queue.
     */
    public String toString() {
        String tempString = ("[");
        for (int i = 0; i < queueObjects.length-1; i++) {
            tempString = tempString + queueObjects[i] + ", ";
        }
        tempString = tempString + queueObjects[queueObjects.length-1] + "]";
        return tempString; 
    }
    boolean isEmpty() {
        if (queueObjects.length == 0)
            return true;
        return false;
    }
    public boolean equals(Object object) {
        if ((object != null) && (object instanceof Queue)) {
            Queue that = (Queue) object;
            if ((that.queueObjects.equals(this.queueObjects))) {
                return true;
            }
        }
        return false;
    }
}
