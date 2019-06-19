public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
//      the signature of an interface object Interface obj = new Class
        Deque<Character> d = new LinkedListDeque();
        for(int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            d.addLast(temp);
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Palindrome p = new Palindrome();
        Deque d = p.wordToDeque(word);
        Boolean b = d.isPalindrome(d);
        return b;
    }
}
