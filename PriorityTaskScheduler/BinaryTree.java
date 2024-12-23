public interface BinaryTree<E extends Comparable<E>> {
    E getRootElement();
    boolean isEmpty();
    int size();
    boolean contains(E e);
    void insert(E e);
    String toStringInOrder();
    boolean remove(E e);
}