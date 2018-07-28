package mit.javaseminar.oo.lesson05;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Util {
	
	public static String rekiHenkan() {
		
		//ロケールを指定してCalendarインスタンスを取得
		Locale locale = new Locale("ja", "JP", "JP");
		Calendar calendar = Calendar.getInstance(locale);

		//calendar.getTime()で現在日時を取得して和暦にフォーマットする
		DateFormat japaseseFormat = new SimpleDateFormat("GGGGy年M月d日", locale);
		String dateStr = japaseseFormat.format(calendar.getTime());
		System.out.println("和暦:" + dateStr);

		//和暦にフォーマットした現在日時を西暦にパースする
		//日付の妥当性をチェックするためsetLenient()にfalseを渡す
		calendar.setLenient(false);
		Date date = null;
		try {
			date = japaseseFormat.parse(dateStr);
		} catch (ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return ("西暦:" + date);  
	}


}
