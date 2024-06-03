import java.util.Iterator;

public class ArrayListIterator<T> implements Iterator<T> { 
    Object current; 
    int currentIndex = 0;
    ArrayList<T> list;
    
    /**
     * Constructor initializing pointer to head of the list for iteration.
     * @param list ArrayList<T> to use as a collection of Objects.
     */ 
    public ArrayListIterator(ArrayList<T> list) { 
        this.list = list;
        current = list.arrListObjects[currentIndex]; 
    } 
    
    /**
     * Returns false if next element does not exist.
     * @return Boolean representation of whether the next element does exist.
     */
    public boolean hasNext() { 
        return currentIndex < list.arrListObjects.length - 1; 
    } 
    
    /**
     * Return object and update pointer.
     * @return T generic type of Object to return.
     *  */ 
    public T next() { 
        Object data = current;
        currentIndex++;
        return ((T) data); 
    } 
} 