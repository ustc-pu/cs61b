/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> {
    Item[] items;
    int size = 0;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[8];
        size = 0;
    }

    public void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts X into the back of the list. */
    public void addLast(Item x) {
        if(size >= items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public Item removeLast() {
        Item a = getLast();
        items[size - 1] = null;
        size = size - 1;
        return a;
    }

    public void insert(Item[] arr, Item item, int position) {
        if (this.size == arr.length) {
            resize(size * 2);
        }
        if (position >= size) {
            this.addLast(item);
        }
        if (position >= 0 & position < size) {
            int count = size;
            while (count != position) {
                arr[count] = arr[count - 1];
                count = count - 1;
            }
            arr[position] = item;
        }
        size = size + 1;
    }

    public void reverse() {
        Item[] arr = this.items;
        int mid = this.size / 2;
        for(int j = 0; j < mid; j++) {
            swap(arr, j, this.size - 1 - j);
        }
    }

    public void swap(Item[] arr, int i, int j) {
        Item temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

 /*   public Item[] replicate() {
        Item[] arr = this.items;
        for(int i = 0; i < this.size; i++) {
            for(int j = 0; j < items[i]; j++) {
                insert(arr, items[i], i);
            }
        }
    }*/

    public static void main(String[] args) {
        AList a = new AList();
        //System.out.println(a.items.length);
        a.addLast(2);
        a.addLast(10);
        a.insert(a.items, 100, 0);
        a.reverse();
        System.out.print(a.getLast());
    }
}