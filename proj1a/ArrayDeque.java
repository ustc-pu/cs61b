public class ArrayDeque<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private double loadFactor;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
        loadFactor = 0;
    }

    public ArrayDeque(ArrayDeque other) {
        ArrayDeque<T> a = new ArrayDeque<>();
        a.size = 0;
        a.loadFactor = 0;
        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    public void resize() {
        //loadFactor = (double) size / items.length;
        if (size == items.length) {
            T[] temp = (T[]) new Object[items.length * 2];
            System.arraycopy(items, nextFirst + 1, temp, 0, items.length - nextFirst - 1);
            System.arraycopy(items, 0, temp, nextFirst - 1, nextLast);
            items = temp;
            nextFirst = items.length - 1;
            nextLast = items.length / 2;
        }
    }

    /*
    * @source https://www.jianshu.com/p/5763d9c1c321
    * */
    public void addFirst(T item) {
        resize();
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1) & (items.length - 1);
        size = size + 1;
    }

    public void addLast(T item) {
        resize();
        items[nextLast] = item;
        nextLast = (nextLast + 1) & (items.length - 1);
        size = size + 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }


    public int size() {
        return size;
    }

    public void printDeque() {
        int i = 0;
        for (i = nextFirst + 1; i < nextLast || i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        if (i == items.length) {
            int j = 0;
            while (j < nextLast) {
                System.out.print(items[j] + " ");
                j = j + 1;
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        nextFirst = (nextFirst + 1) & (items.length - 1);
        T temp = items[nextFirst];
        items[nextFirst] = null;
        size = size - 1;
        return temp;
    }


    public T removeLast() {
        nextLast = (nextLast - 1) & (items.length - 1);
        T temp = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        return temp;
    }

    //random index or shift from first element?
    public T get(int index) {
        if (index >= 0 && index < size) {
            index = (index + nextFirst + 1) & (items.length - 1);
            T temp = items[index];
            return temp;
        } else {
            return null;
        }
    }



    public static void main(String[] args)  {
        ArrayDeque<Integer> a = new ArrayDeque<>();
        //System.out.println(a.items.length);
/*        for (int i = 0; i < 8; i++) {
            a.addLast(i);
        }*/
        a.addFirst(0);
        a.addFirst(1);
        a.addLast(2);
        a.printDeque();
        System.out.println(a.get(2));
        a.addFirst(4);
        a.addLast(5);
        a.addLast(6);
        a.addLast(7);
        a.addFirst(8);
        a.printDeque();
        a.addFirst(9);
        System.out.println(a.removeLast());
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
