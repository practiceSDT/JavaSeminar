package mit.javaseminar.oo.lesson05;

public class DomainKey {
	
	private Gengo gengo;
	//private Bango bango;

	public DomainKey() {
		super();
	}
	
	protected Integer string2Int(String num) {
		return Integer.valueOf(num);
	}

	protected String int2String(Integer num) {
		return String.valueOf(num);
	}

}