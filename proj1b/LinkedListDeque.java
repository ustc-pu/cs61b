public class LinkedListDeque<Item> implements Deque<Item>{
    private class Node {
        private Node pre;
        private Item item;
        private Node next;

        Node(Node p, Item g, Node n) {
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

    public LinkedListDeque(Item g) {
        sentinel = new Node(null, g, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(Item g) {
        Node temp = new Node(sentinel, g, sentinel.next);
        sentinel.next = temp;
        sentinel.next.next.pre = temp;
        size += 1;
    }

    @Override
    public void addLast(Item g) {
        Node temp = new Node(sentinel.pre, g, sentinel);
        sentinel.pre.next = temp;
        sentinel.pre = temp;
        size += 1;
    }

    @Override
    public Item removeFirst() {
        Node temp = sentinel.next;
        Item g = temp.item;
        sentinel.next = temp.next;
        temp.next.pre = sentinel;
        size -= 1;
        return g;
    }

    @Override
    public Item removeLast() {
        Node temp = sentinel.pre;
        Item g = temp.item;
        sentinel.pre = temp.pre;
        temp.pre.next = sentinel;
        size -= 1;
        return g;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        if (size > 0) {
            return size;
        } else {
            return 0;
        }
    }

    @Override
    public Item get(int index) {
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

    private Item getRecursive(int index, Node p) {
        Node temp = p;
        if (index == 0) {
            return temp.next.item;
        } else {
            return getRecursive(index - 1, temp.next);
        }
    }

    public Item getRecursive(int index) {
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

    public boolean isPalindrome(Deque d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        else if (d.removeFirst() != d.removeLast()) {
            return false;
        }
        else {
            isPalindrome(d);
        }
        return true;
    }

    /*@source https://www.youtube.com/watch?v=JNroRiEG7U4*/
    public LinkedListDeque(LinkedListDeque<Item> other) {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.pre = sentinel;
        size = 0;

        for (int i = 0; i < other.size(); i = i + 1) {
            addLast(other.get(i));
        }

    }
}
