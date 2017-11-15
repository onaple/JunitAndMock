package mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.spy;
import static org.powermock.api.mockito.PowerMockito.verifyPrivate;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * Created with IntelliJ IDEA.
 * User: onaple
 * Date: 2017/11/15
 * Time: 14:06
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(PrivatePartialMockingExample.class)
public class PrivatePartialMockingExampleTest1 {
    @Test
    public void demoPrivateMethodMocking() throws Exception {
        final String expected = "TEST VALUE";
        final String nameOfMethodToMock = "methodToMock";
        final String input = "input";

        PrivatePartialMockingExample underTest = spy(new PrivatePartialMockingExample());

       /*
        * Setup the expectation to the private method using the method name
        */
        when(underTest, nameOfMethodToMock, input).thenReturn(expected);
        String s = underTest.methodToTest();
        System.out.println(s);
        assertEquals(expected, s);

        // Optionally verify that the private method was actually called
        verifyPrivate(underTest).invoke(nameOfMethodToMock, input);
    }
}