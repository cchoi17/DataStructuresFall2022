import java.util.NoSuchElementException;

public class ExpandableArrayStack implements Stack {
    private static int MINIMUM_CAPACITY = 16;
    private Object[] elements = new Object[MINIMUM_CAPACITY];
    private int size = 0;

    public int capacity() {
        return elements.length;
    }

    public void push(Object item) {
        if (isFull()) {
            changeCapacity(elements.length * 2);
        }
        elements[size++] = item;
    }

    public Object pop() {
        var head = peek();
        elements[--size] = null;
        if ((elements.length > MINIMUM_CAPACITY) && (size < (0.25 * elements.length))) {
            changeCapacity(elements.length / 2);
        }
        return head;
    }

    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("This stack is empty!");
        }
        return elements[size - 1];
    }

    public int size() {
        return size;
    }

    public void changeCapacity(int newSize) {
        Object[] elements2 = new Object[newSize];
        System.arraycopy(elements, 0, elements, 0, elements.length);
        elements = elements2;
    }

    public boolean isFull() {
        return size == elements.length;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}