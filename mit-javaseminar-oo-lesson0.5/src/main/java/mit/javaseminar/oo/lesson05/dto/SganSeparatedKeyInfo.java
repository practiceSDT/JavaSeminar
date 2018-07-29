package mit.javaseminar.oo.lesson05.dto;

public class SganSeparatedKeyInfo extends AbsKeyInfo {

	public SganSeparatedKeyInfo(String keyinfo) {
		super(keyinfo);
	}

	@Override
	public String getNen(String keyInfo) {
		return keyInfo.substring(0, 4);
	}

	@Override
	public String getBango(String keyInfo) {
		return keyInfo.substring(5, 10);
	}

}
