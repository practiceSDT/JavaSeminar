package mit.javaseminar.oo.lesson05.biz.com.wareki;

import java.util.Map;

import lombok.Getter;
import mit.javaseminar.oo.lesson05.Util;
import mit.javaseminar.oo.lesson05.abs.AbsKeyFactory;
import mit.javaseminar.oo.lesson05.abs.Nen;
import mit.javaseminar.oo.lesson05.dto.AbsKeyInfo;

public class JpNen extends Nen {

	@Getter
	private InterWarekiState warekiState = null;
	
	public JpNen(AbsKeyInfo keyInfo) {
		super(keyInfo);
	}

	@Override
	public String getNen() {
		return this.warekiState.getGengo2String() + super.nen;
	}

	@Override
	public void setNen(AbsKeyInfo keyInfo) {
		/*
		 * この処理は定義化可能です。
		 * なので、20XX年さらに改元されても定義ファイルとクラスの追加だけで良い。
		 * Springを利用するので、勉強会で学んだ後に修正するとします。
		 * 今回はJava8のラムダ式lambdaを利用した初期化が煩雑なMapの初期化テクニックを紹介しておきます。
		 * 共通関数の利用方法です。
		 * 共通関数は、業務に関連した処理ではなく、テクニカルな処理制限や効率のみに利用しましょう。
		 * 理由は同じく勉強会で触れます。
		 */
		Map<Integer, String> kaigenmap = Util.toMap(m -> {
		    m.put(2019, "mit.javaseminar.oo.lesson05.biz.com.wareki.From2019");
		    m.put(1989, "mit.javaseminar.oo.lesson05.biz.com.wareki.From1989");
		    m.put(1926, "mit.javaseminar.oo.lesson05.biz.com.wareki.From1926");
		});
		
		Integer targetClazzKey = kaigenmap.keySet()
				.stream()
				.filter(k -> k <= keyInfo.getIntTypeNen())
				.findFirst()
				.orElse(2019);
		
		try {
			warekiState = (InterWarekiState)Class.forName(kaigenmap.get(targetClazzKey)).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		super.nen = keyInfo.getNen();
		
	}

}
