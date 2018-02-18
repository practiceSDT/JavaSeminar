package study.struct;

public class StructuredBinaryOperationAddDiv {

	public static void main(String[] args) {
		
		Integer first = 3;
		Integer second = 2;
		String operator = "Plus";
		
		System.out.println(commonPrintMessage(first, second, operator));
		
		operator = "Minus";
		
		System.out.println(commonPrintMessage(first, second, operator));
		
		/*
		 * 割り算を追加することになったとする。
		 * ①取扱う値の形が増える。
		 * 　処理同士が型を通して依存しあっている。
		 * ②条件ベースなのでパターンが増える。
		 * 　メッセージの応答ではなく、手続きの条件が中心となっている。
		 */
		operator = "Division";

		System.out.println(commonPrintMessage(first, second, operator));

	}

	/*
	 * なるべくこの部分は変えない決断をする。
	 */
	private static Integer commonCalculation(Integer first, Integer second, String operator) {
		
		switch (operator) {
		case "Plus":
		    return first + second;
		case "Minus":
			return first - second;
		default:
			return 0;
		}
	}
	
	/*
	 * 出力フォーマットが型と直接関係しているため、つられて変更せざるを得ない。
	 */
	private static String commonPrintMessage(Integer first, Integer second, String operator) {

		if(isFloatingPointNumberType(operator)) {
			return String.format(
					"%d %s %d = " + getOutputFormatType(operator) +" です。",
					first,
					operator,
					second,
					commonCalculationFloat(first, second)
					);
		}else {
			return String.format(
					"%d %s %d = " + getOutputFormatType(operator) +" です。",
					first,
					operator,
					second,
					commonCalculation(first, second, operator)
					);
		}
	}
	
	/*
	 * 新たな判定処理を追加することになる。
	 * 条件が増える。
	 */
	private static Boolean isFloatingPointNumberType(String operator) {
		switch (operator) {
		case "Division":
		    return true;
		default:
			return false;
		}
	}

	/*
	 * もともとあるメソッド名との関係が苦しくなる。
	 */
	private static Float commonCalculationFloat(Integer first, Integer second) {
	    return Float.valueOf(first) / Float.valueOf(second);
	}

	/*
	 * いちど分岐を増やしたり変更すると芋ずる式に連鎖していく。
	 */
	private static String getOutputFormatType(String operator) {
		if(isFloatingPointNumberType(operator)) {
			return "%f";
		} else {
			return "%d";
		}
	}
	
}
