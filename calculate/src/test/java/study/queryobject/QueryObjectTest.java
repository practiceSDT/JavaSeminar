package study.queryobject;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class QueryObjectTest {

	@Test
	public void データ検索() throws Exception {
		QueryObject<Person> query = new QueryObject<Person>(Person.class);
		query.addCriteria(Criteria.greaterThan("id", 0));
		Set<Person> results = query.execute();

		assertThat(results.size(), is(2));

		for (Person person : results) {
			if (person.getId() == 0) {
				assertThat(person.getFirstName(), is("山田"));
				//assertThat(person.getLastName(), is("太郎"));
			} else if (person.getId() == 2) {
				assertThat(person.getFirstName(), is("佐藤"));
				//assertThat(person.getLastName(), is("次郎"));
			} else {
				fail();
			}
		}
	}

	@Before
	public void 準備() throws SQLException {
		Statement stmt = DB.createStatement();
		//stmt.execute("DROP TABLE IF EXISTS PERSON");//H2
		DatabaseMetaData dbmd = DB.getMetaData();
		ResultSet rs = dbmd.getTables(null, "TEST", "PERSON", null);
		if(!rs.next())
		{
			stmt.execute("CREATE TABLE PERSON ( id INT PRIMARY KEY, firstname VARCHAR(32))");
		}

		stmt.execute("INSERT INTO PERSON VALUES(0,'山田')");
		stmt.execute("INSERT INTO PERSON VALUES(1,'佐藤')");
		stmt.execute("INSERT INTO PERSON VALUES(2,'鈴木')");
	}

	@BeforeClass
	public static void DB前処理() throws Exception {
		DB.init();
	}

	@AfterClass
	public static void DB後処理() throws Exception {
		DB.terminate();
	}

}
