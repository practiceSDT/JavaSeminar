package study.struct;

public class StructuredBinaryOperationAddDiv {

	public static void main(String[] args) {
		
		Integer first = 3;
		Integer second = 2;
		String operator = "Plus";
		
		System.out.println(commonPrintMessage(first, second, operator));
		
		operator = "Minus";
		
		System.out.println(commonPrintMessage(first, second, operator));
		
		operator = "Division";

		System.out.println(commonPrintMessage(first, second, operator));

	}
	
	private static String commonCalculationArithmetic(Integer first, Integer second, String operator) {
		switch (operator) {
		case "Division":
		    return String.valueOf(Float.valueOf(first) / Float.valueOf(second));
		case "Multi":
			return String.valueOf(first * second);
		default:
			return String.valueOf(commonCalculation(first, second, operator));
		}
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
				"%d %s %d = %s です。",
				first,
				operator,
				second,
				commonCalculationArithmetic(first, second, operator)
				);
	}
}
