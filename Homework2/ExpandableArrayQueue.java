import java.util.NoSuchElementException;

public class ExpandableArrayQueue implements Queue {
    private static int MINIMUM_CAPACITY = 16;
    private Object[] elements = new Object[MINIMUM_CAPACITY];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public int capacity() {
        return elements.length;
    }

    public void enqueue(Object item) {
        if (isFull()) {
            changeCapacity(elements.length * 2);
        }
        elements[tail] = item;
        tail++;
        size++;
    }

    public Object dequeue() {
        var item = peek();
        elements[head] = null;
        ++head;
        size--;
        if ((size() > MINIMUM_CAPACITY) && (size() < (0.25 * elements.length))) {
            changeCapacity(elements.length / 2);
        }
        return item;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("the stack is empty!");
        }
        return elements[head];
    }

    public void changeCapacity(int newSize) {
        Object[] newElements = new Object[newSize];
        System.arraycopy(elements, head, newElements, 0, size);
        elements = newElements;
        tail -= head;
        head = 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
