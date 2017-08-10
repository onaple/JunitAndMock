package chapter1.page7;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TwoStackQueueTest {
    @Test
    public void testPoll() throws Exception {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        twoStackQueue.add(4);
        Assert.assertTrue(1 == twoStackQueue.poll());
        Assert.assertTrue(2 == twoStackQueue.poll());
        Assert.assertTrue(3 == twoStackQueue.poll());
        Assert.assertTrue(4 == twoStackQueue.poll());
    }

    @Test(expected = RuntimeException.class)
    public void testPollException() {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.poll();
    }


    @Test
    public void testPeek() throws Exception {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.add(1);
        twoStackQueue.add(2);
        twoStackQueue.add(3);
        twoStackQueue.add(4);
        Assert.assertTrue(1 == twoStackQueue.peek());
        twoStackQueue.poll();
        Assert.assertTrue(2 == twoStackQueue.peek());
    }

    @Test(expected = RuntimeException.class)
    public void testPeekException() {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.peek();
    }

}