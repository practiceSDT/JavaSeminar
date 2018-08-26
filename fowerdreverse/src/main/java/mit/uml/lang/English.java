package mit.uml.lang;

import mit.uml.fw.*;

public class English extends AbsHello {

	public English(String parameter) {
		super(parameter);
	}

	/**
	 * say Hello.
	 * @return type String
	 */
	protected String sayHello() {
		return "Hello " + super.getName();
	}

	/**
	 * say Goodby.
	 * @return type String
	 */
	protected String sayGoodby() {
		return "Good by " + super.getName();
	}
}