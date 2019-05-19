/** Array based list.
 *  @author Josh Hug
 */

public class AList<Item> {
    Item[] items;
    int size = 0;

    /** Creates an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
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

    public static void main(String[] args) {
        AList<Integer> a = new AList<Integer>[10];
        System.out.println(a.items.length);
        a.addLast(2);
        a.addLast(10);
        System.out.print(a.getLast());
    }
} 