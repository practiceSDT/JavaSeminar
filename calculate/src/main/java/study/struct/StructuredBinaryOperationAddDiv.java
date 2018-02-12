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
	
	private static Boolean isFloatingPointNumberType(String operator) {
		switch (operator) {
		case "Division":
		    return true;
		default:
			return false;
		}
	}

	private static Float commonCalculationFloat(Integer first, Integer second) {
	    return Float.valueOf(first) / Float.valueOf(second);
	}

	private static String getOutputFormatType(String operator) {
		if(isFloatingPointNumberType(operator)) {
			return "%f";
		} else {
			return "%d";
		}
	}
	
}
