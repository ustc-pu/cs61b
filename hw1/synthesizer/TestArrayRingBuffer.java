package synthesizer;
import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
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
        Assert.assertEquals(1, arb.peek());
        Assert.assertEquals(1, arb.dequeue());
        Assert.assertEquals(2, arb.dequeue());
    }

    @Test
    public void test1() {
        AbstractBoundedQueue<Integer> abq = new ArrayRingBuffer<>(100);
        Assert.assertTrue("false", abq.isEmpty());
    }
//
//    @Test
//    public void test2() {
//        ArrayRingBuffer arb = new ArrayRingBuffer(2);
//        arb.enqueue(1);
//        arb.enqueue(2);
//        Iterator<Integer> ite = arb.iterator();
//        while(ite.hasNext()) {
//            System.out.println(ite.next());
////            Assert.assertEquals();
//        }
//    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
        ArrayRingBuffer arb = new ArrayRingBuffer(2);
        arb.enqueue(1);
        arb.enqueue(2);
        Iterator<Integer> ite = arb.iterator();
        System.out.println(arb.fillCount);
        while(ite.hasNext()) {
            System.out.println(ite.next());
        }
    }
} 
