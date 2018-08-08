package mit.javaseminar.oo.lesson05.biz.com.wareki;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import mit.javaseminar.oo.lesson05.Target;
public class TestNGSample {
    private Target target;
    public TestNGSample() {
        System.out.println(
            "★TestNGSampleのコンストラクタを呼び出した★");
    }
    @Test
    public void verifyAdd1() {
        System.out.println("★★★verifyAdd1()を呼び出した★★★");
        int result = target.add(1, 2);
        assertEquals(result, 3);
    }
    @Test
    public void verifyAdd2() {
        System.out.println("★★★verifyAdd2()を呼び出した★★★");
        int result = target.add(3, 3);
        assertEquals(result, 6);
    }
    @BeforeMethod
    public void init() {
        System.out.println("★★init()を呼び出した★★");
        target = new Target();
    }
    @Test(expectedExceptions
        = { java.lang.RuntimeException.class })
    public void exceptionTest() {
        System.out.println(
            "★★★exceptionTest()を呼び出した★★★");
        target.throwException();
    }
}