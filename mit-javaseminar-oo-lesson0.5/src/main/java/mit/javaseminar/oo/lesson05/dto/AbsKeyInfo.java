package mit.javaseminar.oo.lesson05.dto;

import lombok.Data;
import mit.javaseminar.oo.lesson05.Util;

@Data
public abstract class AbsKeyInfo {
	
	private final String nen;
	private final String bango;
	
	public AbsKeyInfo(String keyinfo) {
		this.nen = getNen(keyinfo);
		this.bango = getBango(keyinfo);
	}
	
	public Integer getIntTypeNen() {
		return Util.string2Int(this.getNen());
	}
	
	protected abstract String getNen(String keyInfo);
	protected abstract String getBango(String keyInfo);

}
