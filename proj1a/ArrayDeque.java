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
        if (size == items.length) {
            T[] temp = (T[]) new Object[items.length * 2];
            int first = (nextFirst + 1) & (items.length - 1);
            System.arraycopy(items, first, temp, 0, items.length - first);
            System.arraycopy(items, 0, temp, items.length - first, first);
            items = temp;
            nextFirst = items.length - 1;
            nextLast = items.length / 2;
        }

        loadFactor = (double) size / items.length;
        if (loadFactor <= 0.25 & items.length > 16) {
            T[] temp = (T[]) new Object[items.length / 2];
            int first = (nextFirst + 1) & (items.length - 1);
            System.arraycopy(items, first, temp, 0, size);
            items = temp;
            nextFirst = items.length - 1;
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
        if (size > 0) {
            return size;
        } else {
            return 0;
        }
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
        resize();
        return temp;
    }


    public T removeLast() {
        nextLast = (nextLast - 1) & (items.length - 1);
        T temp = items[nextLast];
        items[nextLast] = null;
        size = size - 1;
        resize();
        return temp;
    }

    //random index or shift from first element? seems shift from first element
    public T get(int index) {
        if (index >= 0 && index < items.length) {
            index = (index + nextFirst + 1) & (items.length - 1);
            T temp = items[index];
            return temp;
        } else {
            return null;
        }
    }
}
