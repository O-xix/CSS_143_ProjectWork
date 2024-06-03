/*
 * Not sure if I really understood the whole overridding thing, so this could be wrong. 
 */

public class Queue extends List {
    /**
     * Gets the state of emptyness of the Queue.
     * @return Boolean representation of whether the Queue is empty or not.
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }
    /**
     * Altered List insert method to insert new Node at the beginning of the Queue. 
     * @param next Data that the new Node should be composed of. 
     * @throws LinkedListException Unique exception class to be thrown.
     */
    public void enqueue(Object next) throws LinkedListException {
        super.insert(next, 0);
    }
    /**
     * Altered List remove method to remove existing Node from the end of the Queue.
     * @return Data of the existing Node to will be removed.
     * @throws LinkedListException Unique exception class to be thrown.
     */
    public Object dequeue() throws LinkedListException {
        return super.remove(super.size() - 1);
    }
    /**
     * Getter method of the size of the Stack.
     * @return Integer representation of the size.
     */
    public int size() {
        return super.size();
    }
    public static void main(String[] args) throws LinkedListException {
        System.out.println("\n\n");
        //Testing Queue class
        System.out.println("Queue tests: ");
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.size());

        //
        Queue queueTwo = new Queue();
        queueTwo.dequeue();
    }
        
}