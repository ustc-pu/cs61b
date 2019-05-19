import org.junit.Test;
import static org.junit.Assert.*;

public class TestSort {

    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        assertArrayEquals(expected, input);
    }

    @Test
    public void testFindsmallest() {
        String[] input = {"i", "hava", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected, actual);

        String[] input2 = {"xiao", "fen", "shi", "ben", "dan"};
        int expected2 = 3;

        int actual2 = Sort.findSmallest(input2, 0);
        assertEquals(expected2, actual2);
    }

}

