import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayPriorityQueue<E extends Comparable<E>> {
    private List<E> elements;

    public ArrayPriorityQueue() {
        elements = new ArrayList<>();
    }

    public void insert(E e) {
        elements.add(e);
        Collections.sort(elements);
    }

    public E removeMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public E max() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public int size() {
        return elements.size();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public E[] toArray(E[] a) {
        return elements.toArray(a);
    }
}