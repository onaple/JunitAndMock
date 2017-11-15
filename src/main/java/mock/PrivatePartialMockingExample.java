package mock;

/**
 * Created with IntelliJ IDEA.
 * User: onaple
 * Date: 2017/11/15
 * Time: 14:05
 */
public final class PrivatePartialMockingExample {
    public String methodToTest() {
        return methodToMock("input");
    }

    private String methodToMock(String input) {
        return "REAL VALUE = " + input;
    }
}
