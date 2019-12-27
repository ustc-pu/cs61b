package synthesizer;
import org.junit.Assert;
import org.junit.Test;
//import static org.junit.Assert.*;
//
/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(2);
        arb.enqueue(1);
        arb.enqueue(2);
//        arb.enqueue(3);
//        arb.enqueue(4);
//        arb.enqueue(5);
//        Assert.assertEquals();
//        arb.dequeue();
        Assert.assertEquals(2, arb.peek());
        Assert.assertEquals(1, arb.dequeue());
        Assert.assertEquals(2, arb.dequeue());
    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
