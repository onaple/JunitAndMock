package mock;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: onaple
 * Date: 2017/11/14
 * Time: 16:53
 * 参考链接：http://yangbolin.cn/2016/07/17/java-ut-mock-framework/
 *
 * easymock不支持private,final,static等方法的mock,
 * easymock如果其中一个方法没有被mock但是被调用了，就会抛异常
 *
 */
public class MockClazzTest {
    @Test
    public void testRun() {
        // ① 创建mock对象
        MockClazz mockClazz = EasyMock.createMock(MockClazz.class);
        // ② 录制mock对象的预期行为和输出
        EasyMock.expect(mockClazz.run(EasyMock.anyString())).andReturn("mocked string for run");
        // ③ 将mock对象切换到播放状态
        EasyMock.replay(mockClazz);
        // ④ 调用mock对象方法进行测试
        String actualString = mockClazz.run("name");
        System.out.println(actualString);
        Assert.assertEquals("mocked string for run", actualString);
        // ⑤ 对mock对象的行为进行验证,验证mock的对象是否按照录制的行为发生
        EasyMock.verify(mockClazz);
    }

    @Test
    public void testGetEatInfo() {

        // ① 创建mock对象
        MockClazz mockClazz = EasyMock.createMock(MockClazz.class);
        // ② 录制mock对象的预期行为和输出
        EasyMock.expect(mockClazz.run(EasyMock.anyString())).andReturn("mocked string for run");
        // ③ 将mock对象切换到播放状态
        EasyMock.replay(mockClazz);
        try {
            String eatInfo = mockClazz.getEatInfo("aa");
        } catch (AssertionError e) {
            System.out.println(e);
        }

    }

    @Test
    public void test() {
        // ① 创建mock对象
        MockClazz mockClazz = Mockito.mock(MockClazz.class);
        // ② 录制mock代码
        Mockito.when(mockClazz.run("A")).thenReturn("B");
        // ③ 执行单元测试
        String actual = mockClazz.run("A");
        Assert.assertEquals(actual,"B");
        // ④ 校验mock对象的行为是否按照mock执行
        Mockito.verify(mockClazz).run("A");
    }

    /**
     * 按照mockito的官方文档，没有被mock的方法返回默认值，具体可以看mockito的官方文档。
     */
    @Test
    public void test1() {
        // ① 创建mock对象
        MockClazz mockClazz = Mockito.mock(MockClazz.class);
        // ② 录制mock代码
        Mockito.when(mockClazz.run("A")).thenReturn("B");
        // ③ 执行单元测试
        String eatInfo = mockClazz.getEatInfo("aa");
        System.out.println(eatInfo);
        Assert.assertEquals(null, eatInfo);
    }

    /**
     * 通过doCallRealMethodl来实现
     */
    @Test
    public void test2() {
        MockClazz mockClazz = Mockito.mock(MockClazz.class);
        Mockito.doCallRealMethod().when(mockClazz).run("A");
        String actual = mockClazz.run("A");
        System.out.println(actual); // A begin run... 原样执行
        Assert.assertEquals("A begin run...", actual);
        System.out.println(mockClazz.run("B")); // null 返回默认值
    }


    /**
     * 通过spy来实现
     */
    @Test
    public void test3() {
        MockClazz mockClazz = Mockito.spy(new MockClazz()); // 注意这里需要new一个
        Mockito.when(mockClazz.run("A")).thenReturn("B");
        String actual = mockClazz.run("C");
        System.out.println(actual); // 输出[C begin run...],原样输出忽略mock逻辑
        Assert.assertEquals("C begin run...", actual);
    }


    /**
     * 通过spy来实现
     */
    @Test
    public void test4() {
        MockClazz mockClazz = Mockito.spy(new MockClazz());
        Mockito.when(mockClazz.run("A")).thenReturn("B");
        System.out.println(mockClazz.run("A")); // 实际执行run的代码,只是修改返回值（先输出A,再返回B begin run...)
    }

    /**
     * 通过spy来实现
     */
    @Test
    public void test5() {
        MockClazz mockClazz = Mockito.mock(MockClazz.class);
        Mockito.doReturn("B").when(mockClazz).run("D");
        Mockito.when(mockClazz.run("C")).thenReturn("E");
        System.out.println(mockClazz.run("C")); // 根本不执行run的代码,直接返回
    }

    @Test
    public void test6(){

    }
}