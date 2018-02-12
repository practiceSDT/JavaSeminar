package study.object.advance.factry;

import study.object.advance.ObjectOrientedBinaryOperationMod;
import study.object.advance.fw.AbsCalculator;
import study.object.advance.pojo.MessageObjects;

public class CalculatorFactory {
	
	/**
	 * 計算用の具象クラスを生成する。
	 * 
	 * @param operator
	 * @return
	 */
	public static AbsCalculator createCalculater(MessageObjects messageObjects) {
		
		try {
			String fqcn = ObjectOrientedBinaryOperationMod.class.getPackage().getName()
					+ "." + 
					messageObjects.getOperator();
			return (AbsCalculator)Class.forName(fqcn).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
