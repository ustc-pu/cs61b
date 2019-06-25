import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testequalChars() {
        boolean actual1 = offByN.equalChars('a', 'f');
        assertEquals(true, actual1);

        boolean actual2 = offByN.equalChars('f', 'a');
        assertEquals(true, actual2);

        boolean actual3 = offByN.equalChars('a', 'h');
        assertEquals(false, actual3);
    }
}
