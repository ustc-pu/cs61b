public class TestSort {

    @org.junit.Test
    public static void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
        org.junit.Assert.assertArrayEquals(expected, input);
    }

    @org.junit.Test
    public static void testFindsmallest() {
        String[] input = {"i", "hava", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        org.junit.Assert.assertEquals(expected, actual);

        String[] input2 = {"xiao", "fen", "shi", "ben", "dan"};
        int expected2 = 3;

        int actual2 = Sort.findSmallest(input2, 0);
        org.junit.Assert.assertEquals(expected2, actual2);
    }

/*    public static void main(String[] args) {
        testFindsmallest();
    }*/
}
