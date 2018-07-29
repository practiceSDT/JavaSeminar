package mit.javaseminar.oo.lesson05.abs;

import lombok.Data;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;

@Data
public abstract class Bango {
	
	private String num = "";

	public Bango(AbsKeyInfo keyInfo) {
		super();
		this.num = keyInfo.getBango();
	}
	
}
