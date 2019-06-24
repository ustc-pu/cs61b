import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testequalChars() {
        boolean actual1 = offByOne.equalChars('e', 'f');
        assertEquals(true, actual1);

        boolean actual2 = offByOne.equalChars('&', '%');
        assertEquals(true, actual2);

        boolean actual3 = offByOne.equalChars('a','A');
        assertEquals(false, actual3);
    }

}
