package mit.javaseminar.oo.lesson05.abs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;

@AllArgsConstructor
@Getter
public abstract class DocumentKey {

	private KeyType keyType;
	private Nen nen;
	private Bango bango;

	public void setKeyInfo(AbsKeyInfo keyInfo) {
		this.getNen().setNen(keyInfo);
		this.getBango().setNum(keyInfo.getBango());

	};
	
}
