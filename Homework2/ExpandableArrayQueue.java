import java.util.NoSuchElementException;

public class ExpandableArrayQueue implements Queue {
    private static int MINIMUM_CAPACITY = 16;
    private Object[] elements= new Object[MINIMUM_CAPACITY];
    private int size = 0;
    private int HEAD = 0;
    private int TAIL = 0;

    public int capacity(){
        return elements.length; 
    }

    public void enqueue(Object item){
        if(isFull()){
            changeSize(elements.length * 2);
        }
        elements[TAIL] = item;
        TAIL++;
        size++;
    }

    public Object dequeue(){
        var item = peek();
        elements[HEAD] = null;
        ++HEAD;
        size--;
        if((size() > MINIMUM_CAPACITY) && (size() < (0.25 * elements.length))) {
            changeSize(elements.length* (1/2)); 
        }
        return item;
    }

    public Object peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("the stack is empty!");
        }
        return elements[HEAD];
    }

    public void changeSize(int newSize){
        Object[] elements2 = new Object[newSize]; 
        System.arraycopy(elements, HEAD, elements2, 0, size);
        elements = elements2; 
        TAIL -= HEAD; 
        HEAD=0; 
    }

    public boolean isFull(){
        return size == elements.length; 
    }

    @Override
    public boolean isEmpty(){
        return size == 0; 
    }
    public int size(){return size;}
}
