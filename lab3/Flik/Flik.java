/** An Integer tester created by Flik Enterprises. */
public class Flik {
    public static boolean isSameNumber(Integer a, Integer b) {
        return a == b;
        /*
        * when Integer is a constant, it has been cashed between -128 and 127.
        * If exceeding this range, we need to new Integer object say Integer(128)
        * which will have different address.
        * thus it returns false outside this range.
        * */
    }
}
