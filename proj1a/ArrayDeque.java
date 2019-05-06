public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private double loadFactor;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 5;
        nextLast = 6;
        size = 0;
        loadFactor = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        ArrayDeque<T> a = new ArrayDeque<>();
        a.size = 0;
        a.loadFactor = 0;
        for(int i = 0; i < other.size(); i++) {
            addLast((T)other.get(i));
        }
    }

    public void resize() {
        loadFactor = (double)size / items.length;
        if(loadFactor >= 0.5) {
            T[] temp = (T[]) new Object[items.length * 2];
            System.arraycopy(items, nextFirst, temp, 0, items.length);
            items = temp;
        }
    }

    public void addFirst(T item) {
        //resize();
        if (nextFirst > 0) {

        }
        else {
            nextFirst = items.length - 1;
        }
        items[nextFirst] = item;
        nextFirst = nextFirst - 1;
        size = size + 1;
    }

    public void addLast(T item) {
        //resize();
        if (nextLast < items.length) {

        } else {
            nextLast = 0;
        }
        items[nextLast] = item;
        nextLast = nextLast + 1;
        size = size + 1;
    }

    public boolean isEmpty() {
        if (size > 0) {
            return false;
        }
        else {
            return true;
        }
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        int i = 0;
        for(i = nextFirst + 1; i < nextLast || i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        if(i == items.length) {
            int j = 0;
            while(j < nextLast) {
                System.out.print(items[j] + " ");
                j = j + 1;
            }
        }
        System.out.println("\n");
    }

    public T removeFirst() {
        T temp = null;
        //items[nextFirst + 1] = null;
        if(nextFirst + 1 < items.length) {
            nextFirst = nextFirst + 1;
        }
        else {
            nextFirst = 0;
        }
        temp = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        return temp;
    }

    public T removeLast() {
        T temp = null;
        if(nextLast - 1 < 0) {
            nextLast = items.length - 1;
        }
        else {
            nextLast = nextLast - 1;
        }
        temp = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        return temp;
    }

    public T get(int index) {
        if(index >=0 && index <= items.length ) {
            T temp = items[index - 1];
            return temp;
        }
        else {
            return null;
        }
    }



    public static void main(String args[]) {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        System.out.println(a.items.length);
        for(int i = 0; i < 8; i++) {
            a.addLast(1);
        }
        a.printDeque();
/*        a.addFirst(1);
        System.out.println(a.isEmpty());
        a.addLast(2);
        a.addLast(3);
        a.addLast(4);
        a.addFirst(0);
        a.addLast(5);
        //a.addLast(6);
        a.addFirst(-1);
        //a.addLast(7);
        //a.addLast(8);
        a.printDeque();
        System.out.println(a.removeLast());
        a.printDeque();
        System.out.println(a.removeLast());
        a.printDeque();
        System.out.println(a.removeFirst());
        a.addLast(4);
        a.addLast(5);
        System.out.println(a.removeFirst());
        System.out.println(a.removeFirst());
        System.out.println(a.removeFirst());
       // System.out.println(a.removeFirst());
       // System.out.println(a.removeFirst());
        a.printDeque();
        System.out.println(a.get(1));*/
    }

}
