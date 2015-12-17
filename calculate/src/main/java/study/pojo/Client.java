package study.pojo;

public class Client {

	public static void main(String[] args) {
		
		CarInteface ci = new Prius();
		
		ci.stopCar();
		
		ci = new Maclaren();
		
		ci.stopCar();
		
		ci = CarFactory.createCar("Prius");
		
		ci.stopCar();

	}

}
