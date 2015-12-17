package study.pojo;

public class CarFactory {
	
	public static CarInteface createCar(String carType){
		
		if ("Prius".equals(carType))
			return new Prius();
		else{
			return new Maclaren();
		}
	}

}
