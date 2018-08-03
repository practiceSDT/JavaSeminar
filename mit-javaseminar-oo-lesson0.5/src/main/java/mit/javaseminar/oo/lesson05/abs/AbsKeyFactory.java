package mit.javaseminar.oo.lesson05.abs;

import mit.javaseminar.oo.lesson05.dto.SganSimpleKeyInfo;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;
import mit.javaseminar.oo.lesson05.dto.DefaultKeyInfo;

public abstract class AbsKeyFactory {

	/*
	 * 共通初期値
	 */
	protected AbsKeyInfo keyInfo = new DefaultKeyInfo("");
	
	public static AbsKeyFactory getKeyFactory(String keyType) {
		AbsKeyFactory absKeyFactory = null;
		
		try {
			absKeyFactory = (AbsKeyFactory)Class.forName(keyType).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return absKeyFactory;
	}
	
	public abstract void splitKeyInfo(AbsKeyInfo keyInfo);
	public abstract KeyType createKeyType();
	public abstract Nen createNen();
	public abstract Bango createBango();
	public abstract DocumentKey createDocumentKey(KeyType keyType,Nen nen,Bango bango);
	
}
