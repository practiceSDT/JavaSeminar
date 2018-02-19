package study.polymorphism;

public class Prius implements CarInteface {
	
	/* (非 Javadoc)
	 * @see study.polymorphism.CarInteface#stopCar()
	 */
	@Override
	public void stopCar(){
		System.out.println(this.getClass().getName() + "は、しずかにとまったよ。");
		
		}

}
