package mit.javaseminar.oo.lesson05.biz.com;

import lombok.Data;
import mit.javaseminar.oo.lesson05.abs.Nen;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;

public class SimpleNen extends Nen {

	public SimpleNen(AbsKeyInfo keyInfo) {
		super(keyInfo);
	}

	@Override
	public String getNen() {
		return super.nen;
	}

	@Override
	public void setNen(AbsKeyInfo keyInfo) {
		super.nen = keyInfo.getNen();
	}
}
