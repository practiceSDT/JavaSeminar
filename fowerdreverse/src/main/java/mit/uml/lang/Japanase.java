package mit.uml.lang;

import mit.uml.fw.*;

public class Japanase extends AbsHello {

	public Japanase(String parameter) {
		super(parameter);
	}

	/**
	 * say Hello.
	 */
	protected String sayHello() {
		return "こんにちは " + super.name;
	}

	protected String sayGoodby() {
		return "さようなら " + super.name;
	}

}