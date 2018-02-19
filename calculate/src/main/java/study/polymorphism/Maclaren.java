package study.polymorphism;

public class Maclaren implements CarInteface {

	@Override
	public void stopCar() {
		System.out.println(this.getClass().getName() + "は、轟音で止まったよ。");

	}

}
