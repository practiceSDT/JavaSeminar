package study.object.base;

public class CalcuraterFactory {
	
	/**
	 * 計算用の具象クラスを生成する。
	 * 
	 * @param operator
	 * @return
	 */
	public static AbsCalculater createCalculater(MessageObjects messageObjects) {
		
		try {
			String fqcn = ObjectOrientedBinaryOperation.class.getPackage().getName()
					+ "." + 
					messageObjects.getOperator();
			return (AbsCalculater)Class.forName(fqcn).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	

}
