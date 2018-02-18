package study.object.base;

/**
 * 
 * @author mitsuik
 *
 */
public class ObjectOrientedBinaryOperation {

	public static void main(String[] args) {
		
		Integer first = 3;
		Integer second = 2;
		String operator = "Plus";
		
		MessageObject messageObjects = new MessageObject(first, operator, second);
		
		AbsCalculator calculator = CalculatorFactory.createCalculater(messageObjects);
		InterAnswer answer = calculator.calculate(messageObjects);
		
		MessageText messageText = new MessageText(messageObjects, calculator, answer);
		
		System.out.println(messageText.getPrintMessage());
		
		operator = "Minus";
		
		messageObjects = new MessageObject(first, operator, second);
		
		calculator = CalculatorFactory.createCalculater(messageObjects);
		answer = calculator.calculate(messageObjects);
		
		messageText = new MessageText(messageObjects, calculator, answer);

		System.out.println(messageText.getPrintMessage());

	}

}
