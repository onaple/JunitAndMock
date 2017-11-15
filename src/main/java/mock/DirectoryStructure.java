package mock;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: onaple
 * Date: 2017/11/15
 * Time: 14:11
 */
public class DirectoryStructure {
    public boolean create(String directoryPath) {
        File directory = new File(directoryPath);
        if (directory.exists()) {
            throw new IllegalArgumentException("\"" + directoryPath + "\" already exists.");
        }
        return directory.mkdirs();
    }
}
