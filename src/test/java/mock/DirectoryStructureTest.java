package mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created with IntelliJ IDEA.
 * User: onaple
 * Date: 2017/11/15
 * Time: 14:12
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(DirectoryStructure.class)
public class DirectoryStructureTest {

    @Test
    public void createDirectoryStructureWhenPathDoesntExist() throws Exception {
        final String directoryPath = "mocked path";

        File directoryMock = mock(File.class);

        // This is how you tell PowerMockito to mock construction of a new File.
        whenNew(File.class).withArguments(directoryPath).thenReturn(directoryMock);

        // Standard expectations
        when(directoryMock.exists()).thenReturn(false);
        when(directoryMock.mkdirs()).thenReturn(true);

        assertTrue(new DirectoryStructure().create(directoryPath));

        // Optionally verify that a new File was "created".
        verifyNew(File.class).withArguments(directoryPath);
    }

}