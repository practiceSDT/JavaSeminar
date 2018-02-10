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
		
		MessageObjects messageObjects = new MessageObjects(first, operator, second);
		
		AbsCalculater calculater = CalcuraterFactory.createCalculater(messageObjects);
		InterAnswer answer = calculater.calculate(messageObjects);
		
		MessageText messageText = new MessageText(messageObjects, calculater, answer);
		
		System.out.println(messageText.getPrintMessage());
		
		operator = "Minus";
		
		messageObjects = new MessageObjects(first, operator, second);
		
		calculater = CalcuraterFactory.createCalculater(messageObjects);
		answer = calculater.calculate(messageObjects);
		
		messageText = new MessageText(messageObjects, calculater, answer);

		System.out.println(messageText.getPrintMessage());

	}

}
