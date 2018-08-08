package mit.javaseminar.oo.lesson05;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mocked;

//@RunWith(JMockit.class)
public class FooTest {

    @Mocked
    private Foo foo;

    @Test
    public void testGetString() {
        // Record
        new Expectations() {{
            foo.getString();
            result = "Mock";
        }};

        // Replay
        String actual = foo.getString();

        // Verify
        assertThat(actual, is("Mock"));
    }

}
