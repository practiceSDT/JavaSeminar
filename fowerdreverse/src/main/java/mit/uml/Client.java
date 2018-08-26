package mit.uml;

import mit.uml.fw.AbsHello;
import mit.uml.lang.English;
import mit.uml.lang.Japanase;

/**
 * client クラス
 */
public class Client {
	
	public static void main(String[] args) {
		
		String lang = "english";
		String mes  = "";
		
		AbsHello helloEnglish = new English("jhon");
		AbsHello helloJapanase = new Japanase("taro");
		
		if ("english".equals(lang)) {
			mes = helloEnglish.sayGreeting();
		} else {
			mes = helloJapanase.sayGreeting();
		}
		
		System.out.println(mes);
		
	}

}