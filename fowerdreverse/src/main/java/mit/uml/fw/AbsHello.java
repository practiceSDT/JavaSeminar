package mit.uml.fw;

import mit.uml.def.SpaceSep;

public abstract class AbsHello {

	protected final String name;
	private final InterSep interSep;

	/**
	 * say Hello.
	 * @return type String
	 */
	 protected abstract String sayHello();

	/**
	 * say Goodby.
	 * @return type String
	 */
	protected abstract String sayGoodby();

	/**
	 * 
	 * @param parameter
	 */
	public AbsHello(String parameter) {
		this.name = parameter;
		this.interSep = new SpaceSep();
	}

	/**
	 * Greeting Template.
	 * @return type String
	 */
	public String sayGreeting() {
		String helloMes = this.sayHello();
		String sepMes = interSep.getSepString();
		String goodbyMes = this.sayGoodby();
		return helloMes + sepMes + goodbyMes;
	}

	protected String getName() {
		return name;
	}

}