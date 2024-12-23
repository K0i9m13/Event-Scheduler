public interface PriorityQueue<E extends Comparable<E>> {
        void insert(E e); 
        E removeMax();
        E max(); 
        int size();
        boolean isEmpty(); 
        }

