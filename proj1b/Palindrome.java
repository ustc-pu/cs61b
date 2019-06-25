public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
//      the signature of an interface object Interface obj = new Class
        Deque<Character> d = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            d.addLast(temp);
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Palindrome p = new Palindrome();
        Deque d = p.wordToDeque(word);
        boolean b = d.isPalindrome(d);
        return b;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Palindrome p = new Palindrome();
        Deque d = p.wordToDeque(word);
        return d.isPalindrome(d, cc);
        //return true;
    }

}
