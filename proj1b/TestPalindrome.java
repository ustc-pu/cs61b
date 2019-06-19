import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        Boolean actual1 = palindrome.isPalindrome("cats");
        assertEquals(false, actual1);

        Boolean actual2 = palindrome.isPalindrome("noon");
        assertEquals(true, actual2);

        Boolean actual3 = palindrome.isPalindrome("Aa");
        assertEquals(false, actual3);

        Boolean actual4 = palindrome.isPalindrome(" ");
        assertEquals(true, actual4);
    }
}
