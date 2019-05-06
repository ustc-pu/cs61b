public class LinkedListDeque<T> {
    private class Node {
        private Node pre;
        private T item;
        private Node next;

        public Node(Node p, T g, Node n) {
            pre = p;
            item = g;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public LinkedListDeque(T g) {
        sentinel = new Node(null, g, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public void addFirst(T g) {
        Node temp = new Node(sentinel, g, sentinel.next);
        sentinel.next = temp;
        sentinel.next.next.pre = temp;
        size += 1;
    }

    public void addLast(T g) {
        Node temp = new Node(sentinel.pre, g, sentinel);
        sentinel.pre.next = temp;
        sentinel.pre = temp;
        size += 1;
    }

    public T removeFirst() {
        Node temp = sentinel.next;
        T g = temp.item;
        sentinel.next = temp.next;
        temp.next.pre = sentinel;
        size -= 1;
        return g;
    }

    public T removeLast() {
        Node temp = sentinel.pre;
        T g = temp.item;
        sentinel.pre = temp.pre;
        temp.pre.next = sentinel;
        size -= 1;
        return g;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Node temp = sentinel;
        int count = 0;
        while (temp.next != sentinel) {
            if (count == index) {
                return temp.next.item;
            }
            temp = temp.next;
            count += 1;
        }
        return null;
    }

    private T getRecursive(int index, Node p) {
        Node temp = p;
        if (index == 0) {
            return temp.next.item;
        } else {
            return getRecursive(index - 1, temp.next);
        }
    }

    public T getRecursive(int index) {
        return getRecursive(index, sentinel);
    }

    public void printDeque() {
        Node temp = sentinel.next;
        while (temp.next != sentinel.next) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /*@source https://www.youtube.com/watch?v=JNroRiEG7U4*/
    public LinkedListDeque(LinkedListDeque<T> other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i = i + 1) {
            addLast(other.get(i));
        }

    }

/**
    public static void main(String[] args) {
        LinkedListDeque<String> d = new LinkedListDeque();
        d.addFirst("2");
        d.addFirst("1");
        d.addLast("3");
        System.out.println(d.size());
        d.printDeque();
        //Gene g = d.removeFirst();
        System.out.println(d.removeFirst());
        //System.out.println(d.removeLast());
        d.printDeque();
        //d.removeFirst();
        //d.removeFirst();
        System.out.println(d.getRecursive(0));

    }
 */
}
