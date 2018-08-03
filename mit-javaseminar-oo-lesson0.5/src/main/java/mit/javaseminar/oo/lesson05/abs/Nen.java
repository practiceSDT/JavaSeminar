package mit.javaseminar.oo.lesson05.abs;

import lombok.Setter;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;

public abstract class Nen {

	protected String nen = "9999";

	public Nen(AbsKeyInfo keyInfo) {
		super();
		this.setNen(keyInfo);
	}

	public abstract void setNen(AbsKeyInfo keyInfo);
	public abstract String getNen();
	
}