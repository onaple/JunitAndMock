package chapter1.page3;

import chapter1.page3.Mystack1;
import org.junit.Test;

import static org.junit.Assert.*;

public class Mystack1Test {

    private Mystack1 mystack1;
    @org.junit.Before
    public void setUp() throws Exception {
        mystack1 = new Mystack1();
        mystack1.push(2);
        mystack1.push(6);
        mystack1.push(1);
        mystack1.push(34);
    }


    @Test
    public void testgetMin() throws Exception {
        assertTrue(mystack1.getmin() == 1);
        mystack1.pop();
        assertTrue(mystack1.getmin() == 1);
        mystack1.pop();
        assertTrue(mystack1.getmin() == 2);
        mystack1.pop();
        assertTrue(mystack1.getmin() == 2);
    }

    @org.junit.Test
    public void testpop() throws Exception {
        assertTrue(mystack1.pop() == 34);
        assertTrue(mystack1.pop() == 1);
        assertTrue(mystack1.pop() == 6);
        assertTrue(mystack1.pop() == 2);
    }

    @Test(expected = RuntimeException.class)
    public void testPopThrowException() {
        Mystack1 mystack = new Mystack1();
        mystack.pop();
    }

    @Test(expected = RuntimeException.class)
    public void testGetMinThrowException() {
        Mystack1 mystack = new Mystack1();
        mystack.getmin();
    }


}