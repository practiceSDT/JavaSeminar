package study.object.base;

public class CalculatorFactory {
	
	/**
	 * 計算用の具象クラスを生成する。
	 * 
	 * @param operator
	 * @return
	 */
	public static AbsCalculator createCalculater(MessageObject messageObjects) {
		
		try {
			String fqcn = ObjectOrientedBinaryOperation.class.getPackage().getName()
					+ "." + 
					messageObjects.getOperator();
			return (AbsCalculator)Class.forName(fqcn).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
