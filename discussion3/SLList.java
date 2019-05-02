 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {   
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
            //System.out.println(size);
        }
    } 

    /* The first item (if it exists) is at sentinel.next. */
    private IntNode sentinel;
    private int size;
/**
    private static void lectureQuestion() {
        SLList L = new SLList();
        IntNode n = IntNode(5, null);
    }*/

    /** Creates an empty SLList. */
    public SLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    public void addLast(int x, IntNode p) {
        if(p.next == null) {
            p.next = new IntNode(x, null);
            size = size + 1;
        }
        else {
            addLast(x, p.next);
        }
    }

    public void addLast(int x) {
        addLast(x, sentinel);
    }

    public void insert(int x, int position) {
        size = size + 1;
        IntNode newNode = new IntNode(x, null);
        IntNode temp = sentinel;
        int count = 0;
        while(temp.next != null) {
            if(count == position) {
                newNode.next = temp.next;
                temp.next = newNode;
                return ;
            }
            else {
                count = count + 1;
                temp = temp.next;
            }
        }
        temp.next = newNode;
    }

    public void reverse() {
        IntNode temp = reverse(sentinel.next);
        sentinel.next = temp;
    }

    public IntNode reverse(IntNode p) {
        if(p == null || p.next == null) {
            return p;
        }
        else {
            IntNode reversed = reverse(p.next);
            p.next.next = p;
            p.next = null;
            return reversed;
        }
    }

    public void reverseInteratively() {
        if(sentinel.next == null || sentinel == null) {
            return ;
        }
        IntNode cur = sentinel.next;
        sentinel.next = null;
        while(cur != null) {
            IntNode temp = cur.next;
            cur.next = sentinel;
            sentinel = cur;
            cur = temp;
        }
    }

    /** Adds x to the end of the list. 
    public void addLast(int x) {
        size = size + 1;        

        IntNode p = sentinel;

        // Advance p to the end of the list. 
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null); 
    } */
    
    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());
        L.addFirst(10);
        L.insert(5,1);
        L.reverseInteratively();
        System.out.println(L.getFirst());
    }
}