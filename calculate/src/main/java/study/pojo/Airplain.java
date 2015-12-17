package study.pojo;

public class Airplain implements Airplaininterface {

	/* (非 Javadoc)
	 * @see study.pojo.Airplaininterface#fly()
	 */
	@Override
	public void fly(){
			System.out.println("そらをとぶ");
	}

//	@Override
//	public void stopCar() {
//		System.out.println("ひこうきぐるまだから");
//		
//	}
	
}
