package mock; 

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/** 
* ClassUnder Tester. 
* @since <pre>十一月 15, 2017</pre> 
* @version 1.0 
*/

@RunWith(PowerMockRunner.class)
//We prepare the IdGenerator for test because the static method is normally not mockable
@PrepareForTest(IdGenerator.class)
public class ClassUnderTest {

    @Test
    public void demoStaticMethodMocking() throws Exception {
        mockStatic(IdGenerator.class);
       /*
        * Setup the expectation using the standard Mockito syntax,
        * generateNewId() will now return 2 everytime it's invoked
        * in this test.
        */
        when(IdGenerator.generateNewId()).thenReturn(2L);

        System.out.println(new ClassUnder().methodToTest());

        // Optionally verify that the static method was actually called
        verifyStatic();
        IdGenerator.generateNewId();
    }

} 
