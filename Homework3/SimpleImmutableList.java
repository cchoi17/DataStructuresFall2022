import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.List;

/**
 * A simple immutable linked list, implement completely from scratch as a
 * singly-linked structure. There aren't too many operations, as additional will
 * be left for homework.
 * 
 * The implementation uses a sum type because I have major null-phobia. Not
 * going to pay the billion-dollar mistake, not with this one.
 */
public sealed interface SimpleImmutableList permits EmptyList, ListNode {
    int size();

    Object head();

    SimpleImmutableList tail();

    static SimpleImmutableList of(Object... items) {
        SimpleImmutableList list = new EmptyList();
        for (var i = items.length - 1; i >= 0; i--) {
            list = new ListNode(items[i], list);
        }
        return list;
    }

    static SimpleImmutableList from(Object head, SimpleImmutableList tail) {
        return new ListNode(head, tail);
    }

    Object at(int index);

    void forEach(Consumer<Object> consumer);

    SimpleImmutableList take(int n);

    SimpleImmutableList drop(int n);

    SimpleImmutableList reversed();

    SimpleImmutableList append(SimpleImmutableList other);

    SimpleImmutableList map(UnaryOperator<Object> f);

    SimpleImmutableList filter(Predicate<Object> p);

    Object last();

    boolean every(Predicate<Object> p);

    boolean some(Predicate<Object> p);

}

final record EmptyList() implements SimpleImmutableList {
    public int size() {
        return 0;
    }

    public Object head() {
        throw new NoSuchElementException();
    }

    public SimpleImmutableList tail() {
        throw new NoSuchElementException();
    }

    public Object at(int index) {
        throw new NoSuchElementException();
    }

    public void forEach(Consumer<Object> consumer) {
        // Intentionally empty: nothing to iterate
    }

    public SimpleImmutableList take(int n) {
        if (n != 0) {
            throw new IllegalArgumentException();
        } else {
        return this;
    }
    }

    public SimpleImmutableList drop(int n) {
        if (n != 0) {
            throw new IllegalArgumentException();
        } else {
        return this;
    }
    }

    public SimpleImmutableList reversed() {
        return this;
    }

    public SimpleImmutableList append(SimpleImmutableList other) {
        return other;
        // appending a list to an empty list returns the list.
    }

    public SimpleImmutableList map(UnaryOperator<Object> f) {
        return this;
    }

    public SimpleImmutableList filter(Predicate<Object> p) {
        return this;
    }

    public boolean every(Predicate<Object> p) {
        // empty list
        return true;
    }

    public boolean some(Predicate<Object> p) {
        return false;
    }

    public Object last() {
        throw new NoSuchElementException();
    }
}

final record ListNode(Object head, SimpleImmutableList tail) implements SimpleImmutableList {
    public int size() {
        return 1 + tail.size();
    }

    public Object at(int index) {
        return index == 0 ? head : tail.at(index - 1);
    }

    public void forEach(Consumer<Object> consumer) {
        consumer.accept(head);
        tail.forEach(consumer);
    }

    public SimpleImmutableList take(int n) {
        if (n > size() || n < 0) {
            throw new IllegalArgumentException();
        } else if (n > 0) {
            return new ListNode(head, tail.take(n - 1));
            // new list will return head and tail until n
        } else {
            return new EmptyList();
        }
    }

    public SimpleImmutableList drop(int n) {
        if (n > size() || n < 0) {
            throw new IllegalArgumentException();
        } else if (n > 0) {
            return tail.drop(n - 1);
        } else {
            return this;
        }
    }

    public SimpleImmutableList reversed() {
        return tail.reversed().append(SimpleImmutableList.of(head));
    }

    public SimpleImmutableList append(SimpleImmutableList other) {
        return new ListNode(head, tail.append(other));
    }

    public SimpleImmutableList map(UnaryOperator<Object> f) {
        if (size() == 0) {
            return new EmptyList();
        }
        return new ListNode(f.apply(head), tail.map(f));
    }

    public SimpleImmutableList filter(Predicate<Object> p) {
        if (!p.test(head)) {
            return tail.filter(p);
        } else {
            return new ListNode(head, tail.filter(p));
        }
    }

    public Object last() {
        return at(size() - 1);
    }

    public boolean every(Predicate<Object> p) {
        return p.test(head) && tail.every(p);
    }

    public boolean some(Predicate<Object> p) {
        return p.test(head) || tail.some(p);
    }

}