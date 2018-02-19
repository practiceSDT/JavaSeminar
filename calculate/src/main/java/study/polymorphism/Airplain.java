package study.polymorphism;

public class Airplain implements Airplaininterface {

	/* (非 Javadoc)
	 * @see study.polymorphism.Airplaininterface#fly()
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
