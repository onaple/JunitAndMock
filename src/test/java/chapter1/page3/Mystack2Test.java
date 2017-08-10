package chapter1.page3;

import chapter1.page3.Mystack2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Mystack2Test {
    private Mystack2 mystack2;
    @Before
    public void setUp() throws Exception {
        mystack2 = new Mystack2();
        mystack2.push(3);
        mystack2.push(2);
        mystack2.push(4);
    }

    @Test
    public void getMin() throws Exception {
        assertTrue(mystack2.getMin() == 2);
        mystack2.pop();
        assertTrue(mystack2.getMin() == 2);
        mystack2.pop();
        assertTrue(mystack2.getMin() == 3);
    }

    @Test
    public void push() throws Exception {
        mystack2.push(1213);
    }

    @Test
    public void pop() throws Exception {
        assertTrue(mystack2.pop() == 4);
        assertTrue(mystack2.pop() == 2);
        assertTrue(mystack2.pop() == 3);
    }
    @Test(expected = RuntimeException.class)
    public void testPopThrowException() {
        Mystack2 mystack = new Mystack2();
        mystack.pop();
    }

    @Test(expected = RuntimeException.class)
    public void testGetMinThrowException() {
        Mystack2 mystack = new Mystack2();
        mystack.getMin();
    }

}