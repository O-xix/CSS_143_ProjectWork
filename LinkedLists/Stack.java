/*
 * Not sure if I really understood the whole overridding thing, so this could be wrong. 
 */

public class Stack extends List {
    /**
     * Gets the state of emptyness of the Stack.
     * @return Boolean representation of whether the Stack is empty or not.
     */
    public boolean isEmpty() {
        return super.isEmpty();
    }
    /**
     * Altered List insert method to insert new Node at the beginning of the Stack. 
     * @param next Data that the new Node should be composed of. 
     * @throws LinkedListException Unique exception class to be thrown.
     */
    public void push(Object next) throws LinkedListException {
        super.insert(next, 0);
    }
    /**
     * Altered List remove method to remove existing Node from the beginning of the Stack.
     * @return Data of the existing Node to will be removed.
     * @throws LinkedListException Unique exception class to be thrown.
     */
    public Object pop() throws LinkedListException {
        return super.remove(0);
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
        //Testing Stack class
        System.out.println("Stack tests: ");
        Stack stack = new Stack();
        System.out.println(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        System.out.println(stack.isEmpty());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.size());

        //
        Stack stackTwo = new Stack();
        stackTwo.pop();
    }
}