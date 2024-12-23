public class LinkedBinarySearchTree<E extends Comparable<E>> implements BinaryTree<E> {
    private E data;
    private LinkedBinarySearchTree<E> leftSubTree;
    private LinkedBinarySearchTree<E> rightSubTree;
    private int count;

    public LinkedBinarySearchTree() {
        this.data = null;
        leftSubTree = null;
        rightSubTree = null;
        count = 0;
    }

    public LinkedBinarySearchTree(E data) {
        this.data = data;
        leftSubTree = new LinkedBinarySearchTree<>();
        rightSubTree = new LinkedBinarySearchTree<>();
        count = 1;
    }

    @Override
    public E getRootElement() {
        return data;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean contains(E e) {
        return containsElement(this, e);
    }

    private boolean containsElement(LinkedBinarySearchTree<E> tree, E e) {
        if (tree == null || tree.isEmpty()) {
            return false;
        }
        if (tree.data.equals(e)) {
            return true;
        } else if (e.compareTo(tree.data) < 0) {
            return containsElement(tree.leftSubTree, e);
        } else {
            return containsElement(tree.rightSubTree, e);
        }
    }

    @Override
    public void insert(E e) {
        if (isEmpty()) {
            data = e;
            leftSubTree = new LinkedBinarySearchTree<>();
            rightSubTree = new LinkedBinarySearchTree<>();
            count = 1;
        } else {
            if (e.compareTo(data) < 0) {
                leftSubTree.insert(e);
            } else if (e.compareTo(data) > 0) {
                rightSubTree.insert(e);
            } else {
                // Handle duplicate elements if needed
            }
            count++;
        }
    }

    @Override
    public String toStringInOrder() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            if (leftSubTree != null) {
                sb.append(leftSubTree.toStringInOrder());
            }
            sb.append(data).append(" ");
            if (rightSubTree != null) {
                sb.append(rightSubTree.toStringInOrder());
            }
        }
        return sb.toString();
    }

    @Override
    public String toStringPreOrder() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            sb.append(data).append(" ");
            if (leftSubTree != null) {
                sb.append(leftSubTree.toStringPreOrder());
            }
            if (rightSubTree != null) {
                sb.append(rightSubTree.toStringPreOrder());
            }
        }
        return sb.toString();
    }

    @Override
    public String toStringPostOrder() {
        StringBuilder sb = new StringBuilder();
        if (!isEmpty()) {
            if (leftSubTree != null) {
                sb.append(leftSubTree.toStringPostOrder());
            }
            if (rightSubTree != null) {
                sb.append(rightSubTree.toStringPostOrder());
            }
            sb.append(data).append(" ");
        }
        return sb.toString();
    }

    @Override
    public boolean remove(E e) {
        // Implementation of remove method
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tree:\n");
        sb.append("In: ").append(toStringInOrder()).append("\t");
        return sb.toString();
    }
}