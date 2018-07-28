package mit.javaseminar.oo.lesson05;

public class Gengo {

	protected String gengo = "元号";

	public Gengo() {
		super();
	}

	public String getWareki(DomainKey bango) {
		return gengo + bango.toString();
	}

}