package mit.javaseminar.oo.lesson05;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;

public class Util {
	
	public static final String BASE_FQCN = "mit.javaseminar.oo.lesson05";

	public static Integer string2Int(String num) {
		return Integer.valueOf(num);
	}

	public static String int2String(Integer num) {
		return String.valueOf(num);
	}
	
	/*
	 * Mapの初期値設定にラムダ式lambdaを使うための関数型インタフェース定義
	 * From java8
	 */
	public static <K, V> Map<K, V> toMap(Consumer<Map<K, V>> initializer) {
	    Map<K, V> map = new LinkedHashMap<>();
	    initializer.accept(map);
	    return map;
	}
	
	/*
	 * チート
	 */
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
