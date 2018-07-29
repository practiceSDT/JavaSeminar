package mit.javaseminar.oo.lesson05;

import mit.javaseminar.oo.lesson05.abs.AbsKeyFactory;
import mit.javaseminar.oo.lesson05.abs.Bango;
import mit.javaseminar.oo.lesson05.abs.DocumentKey;
import mit.javaseminar.oo.lesson05.abs.KeyType;
import mit.javaseminar.oo.lesson05.abs.Nen;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;
import mit.javaseminar.oo.lesson05.dto.SganSimpleKeyInfo;

public class Client {

	public static void main(String[] args) {

		System.out.println("=== sgan 元号なし ===");
		AbsKeyFactory sganFactory = AbsKeyFactory.getKeyFactory(Util.BASE_FQCN + ".biz.sgan.n.SganFactory");
		
		KeyType sganKeyType = sganFactory.createKeyType();
		Nen sganNen = sganFactory.createNen();
		Bango sganBango = sganFactory.createBango();
		
		DocumentKey sganDocumentKey = sganFactory.createDocumentKey(sganKeyType, sganNen, sganBango);
		
		AbsKeyInfo sganSimpleKeyInfo = new SganSimpleKeyInfo("2001123456");
		
		sganDocumentKey.setKeyInfo(sganSimpleKeyInfo);

		System.out.println(sganDocumentKey.getKeyType());
		System.out.println(sganDocumentKey.getNen().getNen());
		System.out.println(sganDocumentKey.getBango());

		System.out.println("=== sgan 元号あり ===");
		AbsKeyFactory sganOldFactory = AbsKeyFactory.getKeyFactory(Util.BASE_FQCN + ".biz.sgan.o.SganOldFactory");

		KeyType sganOldKeyType = sganOldFactory.createKeyType();
		Nen sganOldNen = sganOldFactory.createNen();
		Bango sganOldBango = sganOldFactory.createBango();
		
		DocumentKey sganOldDocumentKey = sganOldFactory.createDocumentKey(sganOldKeyType, sganOldNen, sganOldBango);
		
		sganSimpleKeyInfo = new SganSimpleKeyInfo("1980123456");
		sganOldDocumentKey.setKeyInfo(sganSimpleKeyInfo);

		System.out.println(sganOldDocumentKey.getKeyType());
		System.out.println(sganOldDocumentKey.getNen().getNen());
		System.out.println(sganOldDocumentKey.getBango());

		System.out.println("=== cusstom 元号あり ===");
		AbsKeyFactory sganCustomFactory = AbsKeyFactory.getKeyFactory(Util.BASE_FQCN + ".biz.sgan.custom.SganCustomFactory");

		KeyType sganCustomKeyType = sganCustomFactory.createKeyType();
		Nen sganCustomNen = sganCustomFactory.createNen();
		Bango sganCustomBango = sganCustomFactory.createBango();
		
		DocumentKey sganCustomDocumentKey = sganCustomFactory.createDocumentKey(sganCustomKeyType, sganCustomNen, sganCustomBango);
		
		sganSimpleKeyInfo = new SganSimpleKeyInfo("2050123456");
		sganCustomDocumentKey.setKeyInfo(sganSimpleKeyInfo);

		System.out.println(sganCustomDocumentKey.getKeyType());
		System.out.println(sganCustomDocumentKey.getNen().getNen());
		System.out.println(sganCustomDocumentKey.getBango());

		
	}

}
