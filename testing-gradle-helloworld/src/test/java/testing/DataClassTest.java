package testing;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataClassTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		DataClass dataClass = new DataClass();
		dataClass.setId("test");
		assertThat(dataClass.getId(), is("test"));
	}

}
