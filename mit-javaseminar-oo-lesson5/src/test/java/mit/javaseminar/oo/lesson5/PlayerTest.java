package mit.javaseminar.oo.lesson5;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import lombok.extern.java.Log;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Injectable;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
@Log
public class PlayerTest {

	//Mockedは全てのPlayerをモックとするため、テスト対象として使えなくなる。
	//@Injectableは、特定のインスタンスのみ
	@Injectable
	private Player mockedPlayer;
	@Injectable
	private Hand mockedHand;
	@Injectable
	private Card mockedCard;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public final void testPlayer() {
		String expectedName = "testedMan";
		Master expectedMaster = new Master();
		Table expectedTable = new Table();

		Player sut = new Player(expectedName,expectedMaster,expectedTable);

		String actualName = Deencapsulation.getField(sut, "name_");
		Master actualMaster = Deencapsulation.getField(sut, "master_");
		Table actualTable = Deencapsulation.getField(sut, "table_");
		
		assertThat("コンストラクタで設定されたname_インスタンスの確認", 
				actualName, is(sameInstance(expectedName)));
		assertThat("コンストラクタで設定されたmaster_インスタンスの確認", 
				actualMaster, is(sameInstance(expectedMaster)));
		assertThat("コンストラクタで設定されたtable_インスタンスの確認", 
				actualTable, is(sameInstance(expectedTable)));
	}

	@Test
	public final void testPlay() {
		//標準出力の取得用にByteArrayに設定し、assertする際に利用する。
	    ByteArrayOutputStream bo = new ByteArrayOutputStream();
	    System.setOut(new PrintStream(bo));

	    new Expectations() {
            {
                mockedCard.showCard();result = "S7";
            }
        };
        new Expectations() {
            {
                mockedHand.pickCard();result = mockedCard;
            }
        };
        new Expectations() {
            {
                mockedPlayer.getName();result = "山田";
                mockedPlayer.showHand();result = mockedHand;
            }
        };
		Player sut = new Player("fake", new Master(), new Table());
		String expected = "村田";
		Deencapsulation.setField(sut, "name_" ,expected);
		sut.play(mockedPlayer);
	    try {
	    	bo.flush();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	    String allWrittenLines = new String(bo.toByteArray());
	    log.info(allWrittenLines);
	    //もともと手札のある場合などバリエーションの試験を増やす
	    String expectedMes = String.format(
	    		"村田：山田さんから S7 を引きました%n村田：を捨てました%n村田：残りの手札は S7 です"
	    		);
	    assertTrue("捨てたカードの表示確認", allWrittenLines.contains(expectedMes));
	            
	}

	@Test
	public final void testShowHand() {
	}

	@Test
	public final void testReceiveCard() {
	}

	@Test
	public final void testToString() {
		Player sut = new Player("fake", new Master(), new Table());
		String expected = "村田";
		Deencapsulation.setField(sut, "name_" ,expected);
		String actual = sut.getName();
		
		assertThat("名前の確認", actual, is(expected));
				
	}

}
