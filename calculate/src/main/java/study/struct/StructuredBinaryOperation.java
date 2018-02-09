package study.struct;

/**
 * 
 * @author mitsuik
 *
 */
public class StructuredBinaryOperation {

	public static void main(String[] args) {
		
		Integer first = 3;
		Integer second = 2;
		String operator = "Plus";
		
		System.out.println(commonPrintMessage(first, second, operator));
		
		operator = "Minus";
		
		System.out.println(commonPrintMessage(first, second, operator));

	}
	
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
	
	private static String commonPrintMessage(Integer first, Integer second, String operator) {
		
		return String.format(
				"%d %s %d = %d です。",
				first,
				operator,
				second,
				commonCalculation(first, second, operator)
				);
	}
}
