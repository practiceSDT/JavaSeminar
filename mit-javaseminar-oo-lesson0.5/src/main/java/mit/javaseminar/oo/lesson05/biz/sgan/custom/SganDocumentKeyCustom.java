package mit.javaseminar.oo.lesson05.biz.sgan.custom;

import mit.javaseminar.oo.lesson05.abs.Bango;
import mit.javaseminar.oo.lesson05.abs.DocumentKey;
import mit.javaseminar.oo.lesson05.abs.KeyType;
import mit.javaseminar.oo.lesson05.abs.Nen;

public class SganDocumentKeyCustom extends DocumentKey {

	public SganDocumentKeyCustom(KeyType keyType, Nen nen, Bango bango) {
		super(keyType, nen, bango);
	}

}
