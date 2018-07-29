package mit.javaseminar.oo.lesson05.dto;

public class DefaultKeyInfo extends AbsKeyInfo {

	public DefaultKeyInfo(String keyinfo) {
		super(keyinfo);
	}

	@Override
	protected String getNen(String keyInfo) {
		return "1900";
	}

	@Override
	protected String getBango(String keyInfo) {
		return "";
	}

}
