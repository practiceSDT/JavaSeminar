package study.object;

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
		
		ICalculate calculater = null;
		
		try {
			String fqcn = ObjectOrientedBinaryOperation.class.getPackage().getName()
					+ "." + 
					messageObjects.getOperator();
			calculater = (ICalculate)Class.forName(fqcn).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		} 
		
		IAnswer answer = calculater.calculate(messageObjects);
		MessageText messageText = new MessageText();
		messageText.setMessageObjects(messageObjects);
		messageText.setAnswer(answer);
		
		System.out.println(messageText.getPrintMessage());

	}

}
