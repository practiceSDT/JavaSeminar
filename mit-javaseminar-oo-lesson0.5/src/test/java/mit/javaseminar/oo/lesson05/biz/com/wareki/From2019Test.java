package mit.javaseminar.oo.lesson05.biz.com.wareki;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

import mit.javaseminar.oo.lesson05.dto.SganSimpleKeyInfo;

public class From2019Test extends From2019 {

	@Test
	public void testGetGengo2String() {
		From2019 sut = new From2019();
		String actual = sut.getGengo2String();
		assertThat(actual, is("改元"));
	}

	@Test
	public void testGetGengo1String() {
		From2019 sut = new From2019();
		String actual = sut.getGengo1String();
		assertThat(actual, is("改"));
	}

	@Test
	public void testGetGengoInitial() {
		From2019 sut = new From2019();
		String actual = sut.getGengoInitial();
		assertThat(actual, is("K"));
	}

	@Test
	public void testGetGengoNen() {
/*		From2019 sut = new From2019();
		String actual = sut.getGengoNen(new JpNen(new SganSimpleKeyInfo("2050123456")));
		assertThat(actual, is("2"));
*/	
	}

}
