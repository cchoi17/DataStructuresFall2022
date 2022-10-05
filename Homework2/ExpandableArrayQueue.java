import java.util.NoSuchElementException;

public class ExpandableArrayQueue implements Queue {
    private Object[] q;
    private int size = 0;
    private int head = 0;
    private int tail = 0;
    private int cap = 16; 

    public int capacity(){
        return q.length; 
    }
    public void enqueue(Object item){
        if(size == 0){
            q[tail] = item;
            tail = (tail + 1) % q.length;
            size++;
        }
        else if(isFull()){
            doubleSize();
            throw new NoSuchElementException("Queue is full!");
        }
    }

    public Object dequeue(){
        if (isEmpty()) {
            throw new NoSuchElementException("Cannot remove from empty queue");
        }
        var item = q[head];
        q[head] = null;
        head = (head + 1) % q.length;
        size--;
        return item;
    }

    public Object peek(){
        if (isEmpty()) {
            throw new NoSuchElementException("the stack is empty!");
        }
        return q[size - 1];
    }

    public void doubleSize(){

    }

    public void halfSize(){

    }

    public boolean isFull(){
        return size == q.length; 
    }

    @Override
    public boolean isEmpty(){
        return size == 0; 
    }
}
