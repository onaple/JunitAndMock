package mock;

/**
 * Created with IntelliJ IDEA.
 * User: onaple
 * Date: 2017/11/15
 * Time: 14:18
 */
public class ClassUnder {
    public long methodToTest() {
        final long id = IdGenerator.generateNewId();
        System.out.println(id);
        return id;
    }
}
