package mit.javaseminar.oo.lesson05.biz.sgan.custom;

import mit.javaseminar.oo.lesson05.abs.AbsKeyFactory;
import mit.javaseminar.oo.lesson05.abs.Bango;
import mit.javaseminar.oo.lesson05.abs.DocumentKey;
import mit.javaseminar.oo.lesson05.abs.KeyType;
import mit.javaseminar.oo.lesson05.abs.Nen;
import mit.javaseminar.oo.lesson05.biz.com.NoNotationKeyType;
import mit.javaseminar.oo.lesson05.biz.com.SimpleNen;
import mit.javaseminar.oo.lesson05.biz.com.wareki.JpNen;
import mit.javaseminar.oo.lesson05.biz.sgan.items.China;
import mit.javaseminar.oo.lesson05.biz.sgan.items.SganBango;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;

public class SganCustomFactory extends AbsKeyFactory {

	@Override
	public KeyType createKeyType() {
		return new China();
	}

	@Override
	public Nen createNen() {
		return new JpNen(super.keyInfo);
	}

	@Override
	public Bango createBango() {
		return new SganBango(super.keyInfo);
	}

	@Override
	public DocumentKey createDocumentKey(KeyType keyType, Nen nen, Bango bango) {
		return new SganDocumentKeyCustom(keyType, nen, bango);
	}

	@Override
	public void splitKeyInfo(AbsKeyInfo keyInfo) {
		// TODO 自動生成されたメソッド・スタブ
		
	}

}
