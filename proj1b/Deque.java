public interface Deque<Item> {
    void addFirst(Item item);

    void addLast(Item item);

    boolean isEmpty();

    int size();

    void printDeque();

    Item removeFirst();

    Item removeLast();

    Item get(int index);

    boolean isPalindrome(Deque d);

    boolean isPalindrome(Deque d, CharacterComparator cc);
}
