public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
//        LinkedListDeque<String> d = new LinkedListDeque();
        Deque<Character> d = new LinkedListDeque();
        for(int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            d.addLast(temp);
        }
        return d;
    }
}
