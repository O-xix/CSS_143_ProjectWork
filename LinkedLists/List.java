public class List {
    Node head = null;
    int size;

    /**
     * Method to insert new Node into the List.
     * @param objectToInsert Data for the new Node.
     * @param index Index of the List that the new Node is to be inserted at.
     * @throws LinkedListException Unique exception class to be thrown.
     */
    protected void insert(Object objectToInsert, int index) throws LinkedListException {
        Node insertNode = new Node(objectToInsert);
        if (index < 0) {
            throw new LinkedListException("LinkedList: Invalid index.");
        }
        else if (index == 0) {
            insertNode.next = head;
            head = insertNode;
            return;
        }
        Node reading = head;
        int readingIndex = 0;
        while (reading != null && readingIndex < index - 1) {
            reading = reading.next;
            readingIndex++;
        }
        if (reading == null) {
            throw new LinkedListException("LinkedList: Index out of bounds.");
        }
        insertNode.next = reading.next;
        reading.next = insertNode;
    }
    /**
     * Method to remove existing Node from the List and returns it.
     * @param index Integer value of the index that Node should be removed at.
     * @return Object that exists in Node's data.
     * @throws LinkedListException Unique exception class to be thrown.
     */
    protected Object remove(int index) throws LinkedListException  {
        Node reading = head;
        if (index < 0) {
            throw new LinkedListException("LinkedList: Invalid index.");
        }
        else if (index >= size) {
            throw new LinkedListException("LinkedList: Index out of bounds.");
        }
        else if (index == 0 && head != null) {
            reading = new Node(head);
            head = head.next;
            return reading;
        }
        while (index > 1) {
            reading = reading.next;
            index--;
        }
        Node returningNode = reading.next;
        reading.next = reading.next.next;
        size--;
        return returningNode.data;
    }
    /**
     * Method to add or insert a new Node at the end of the List.
     * @param next Data for the new Node.
     */
    private void append(Object next) {
    	Node nextNode = new Node(next);
        if (head == null) {
            head = new Node(nextNode);
            size++;
            return;
        }
	    nextNode.next = null;

        Node last = head; 
        while (last.next != null) {
            last = last.next;
        }
        last.next = nextNode;
        size++;
        return;
    }
    /**
     * Method to remove/delete existing Node from the List that does not return it.
     * @param index Integer value of the index that Node should be deleted at.
     * @throws LinkedListException Unique exception class to be thrown.
     */
    private void delete(int index) throws LinkedListException {
        Node reading = head;
        if (index < 0) {
            throw new LinkedListException("LinkedList: Invalid index.");
        }
        else if (index >= size) {
            throw new LinkedListException("LinkedList: Index out of bounds.");
        }
        else if (index == 0 && head != null) {
            head = head.next;
            return;
        }
        while (index > 1) {
            reading = reading.next;
            index--;
        }
        reading.next = reading.next.next;
        size--;
        return;
    }
    /**
     * Getter method of the size of the List.
     * @return Integer representation of the size.
     */
    protected int size() {
        return size;
    }
    public String toString() {
        Node reading = head;
        String result = "";
        while (reading != null) {
            result = result + reading.data.toString() + ", ";
            reading = reading.next;
        }
        return result;
    }
    /**
     * Gets the state of emptyness of the List.
     * @return Boolean representation of whether the List is empty or not.
     */
    protected boolean isEmpty() {
        if (head == null) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * Gets the integer representation of where a Node consisting the target Object is located. 
     * @param target Object to be searched for.
     * @return Integer representation of the index.
     */
    private int indexOf(Object target) {
        Node reading = head;
        int i = 0;
        while (reading.data != target) {
            i++;
            reading = reading.next;
        }
        return i;
    }
       
    public static void main(String[] args) throws LinkedListException {
        //Testing List class
        System.out.println("List tests: ");
        List list = new List();
        System.out.println(list.isEmpty());
        list.append(1);
        list.append(2);
        System.out.println(list);
        list.insert(3, 1);
        System.out.println(list.indexOf(3));
        System.out.println(list);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list);
        list.delete(0);
        System.out.println(list);
        System.out.println(list.isEmpty());

        //
        List listTwo = new List();
        //listTwo.remove(0);
        listTwo.remove(2);
    }
    /**
     * Node
     */
    public class Node {
        public Node next;
        public Object data; 

        /**
         * Variable constructor for a new Node including data.
         * @param objectToInsert Data to be contained in the new Node.
         */
        public Node(Object objectToInsert) {
            this.next = null;
            this.data = objectToInsert;
        }
        /**
         * Variable constructor for a new Node including data and a reference to the next Node.
         * @param objectToInsert Data to be contained in the new Node.
         * @param next Node to be chained to.
         */
        public Node(Object objectToInsert, Node next) {
            this.next = null;
            this.data = objectToInsert;
        }

        /**
         * Copy constructor for a new Node based on another Node's construction.
         * @param nodeToCopy Node to copy attributes from.
         */
        public Node(Node nodeToCopy) {
            this.next = null;
            this.data = nodeToCopy.data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}