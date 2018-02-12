package study.object.advance;

import study.object.advance.factry.CalculatorFactory;
import study.object.advance.fw.AbsCalculator;
import study.object.advance.fw.InterAnswer;
import study.object.advance.fw.InterMessageText;
import study.object.advance.pojo.MessageObjects;
import study.object.advance.view.MessageText;

/**
 * 
 * @author mitsuik
 *
 */
public class ObjectOrientedBinaryOperationMod {

	public static void main(String[] args) {
		
		Integer first = 3;
		Integer second = 2;
		String operator = "Plus";
		
		MessageObjects messageObjects = new MessageObjects(first, operator, second);
		
		AbsCalculator calculator = CalculatorFactory.createCalculater(messageObjects);
		InterAnswer answer = calculator.calculate(messageObjects);
		
		InterMessageText messageText = new MessageText(messageObjects, calculator, answer);
		
		System.out.println(messageText.getPrintMessage());
		
		operator = "Minus";
		
		messageObjects = new MessageObjects(first, operator, second);
		
		calculator = CalculatorFactory.createCalculater(messageObjects);
		answer = calculator.calculate(messageObjects);
		
		messageText = new MessageText(messageObjects, calculator, answer);

		System.out.println(messageText.getPrintMessage());
			
		operator = "Division";
		
		messageObjects = new MessageObjects(first, operator, second);
		
		calculator = CalculatorFactory.createCalculater(messageObjects);
		answer = calculator.calculate(messageObjects);
		
		messageText = new MessageText(messageObjects, calculator, answer);

		System.out.println(messageText.getPrintMessage());
}

}
