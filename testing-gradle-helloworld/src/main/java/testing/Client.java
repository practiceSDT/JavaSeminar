package testing;

public class Client {

	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		DataClass dataClass = new DataClass();
		dataClass.setId("Mr. Hogehoge");
		
		System.out.println("Hello World!" + dataClass);
		
	}

}
