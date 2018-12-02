package mit.javaseminar.oo.lesson5;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import mockit.Deencapsulation;

public class TableTest {

	static List<Card> fakeDisposedCards_;
	static List<Card> sameCards = new ArrayList<>();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		sameCards.add(new Card(1, 11));
		sameCards.add(new Card(3, 11));
		
		fakeDisposedCards_ = new ArrayList<>(Arrays.asList(new Card(2, 3),new Card(4, 5)));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testDisposeCard_正常処理() {
		  Table sut = new Table();
		  
		  //標準出力の取得用にByteArrayに設定し、assertする際に利用する。
	      ByteArrayOutputStream bo = new ByteArrayOutputStream();
	      System.setOut(new PrintStream(bo));
		  
	      //privateメンバは外部から値を設定できないが、jmockitの機能で設定することができる。
		  Deencapsulation.setField(sut, "disposedCards_" ,fakeDisposedCards_);
		  sut.disposeCard(sameCards);
	      try {
			bo.flush();
	      } catch (IOException e) {
	    	e.printStackTrace();
	      }
	      String allWrittenLines = new String(bo.toByteArray());
	      assertTrue("捨てたカードの表示確認", allWrittenLines.contains("SJ CJ を捨てました"));
	}

}
