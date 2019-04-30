public class LinkedListDeque<Gene> {
    public class Node{
        public Node pre;
        public Gene item;
        public Node next;

        private Node(Node p, Gene g, Node n) {
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

    public LinkedListDeque(Gene g) {
        sentinel = new Node(null, g, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    public void addFirst(Gene g) {
        Node temp = new Node(sentinel, g, sentinel.next);
        sentinel.next = temp;
        sentinel.next.next.pre = temp;
        size += 1;
    }

    public void addLast(Gene g) {
        Node temp = new Node(sentinel.pre, g, sentinel);
        sentinel.pre.next = temp;
        sentinel.pre = temp;
        size += 1;
    }

    public Gene removeFirst() {
        Node temp = sentinel.next;
        Gene g = temp.item;
        sentinel.next = temp.next;
        temp.next.pre = sentinel;
        size -= 1;
        return g;
    }

    public Gene removeLast() {
        Node temp = sentinel.pre;
        Gene g = temp.item;
        sentinel.pre = temp.pre;
        temp.pre.next = sentinel;
        size -= 1;
        return g;
    }

    public boolean isEmpty() {
        if(size == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    public Gene get(int index) {
        Node temp = sentinel;
        int count = 0;
        while(temp.next != sentinel) {
            if(count == index) {
                return temp.next.item;
            }
            temp = temp.next;
            count += 1;
        }
        return null;
    }

    private Gene getRecursive(int index, Node p) {
        Node temp = p;
        if(index == 0) {
            return temp.next.item;
        }
        else {
            return getRecursive(index - 1, temp.next);
        }
    }

    public Gene getRecursive(int index) {
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

    //@source https://www.youtube.com/watch?v=JNroRiEG7U4
    public LinkedListDeque(LinkedListDeque<Gene> other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;

        for(int i = 0; i < other.size(); i = i + 1) {
            addLast(other.get(i));
        }

    }

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
}