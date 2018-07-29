package mit.javaseminar.oo.lesson05.dto;

public class SganSimpleKeyInfo extends AbsKeyInfo {

	public SganSimpleKeyInfo(String keyinfo) {
		super(keyinfo);
	}

	@Override
	public String getNen(String keyInfo) {
		return keyInfo.substring(0, 4);
	}

	@Override
	public String getBango(String keyInfo) {
		return keyInfo.substring(4, 9);
	}

}
