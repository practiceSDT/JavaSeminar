package study.lambda;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CaluclateObject implements InterCaluclateObject {

	@Getter
	private final MessageObject messageObject;

	/*
	 * ラムダ式の関数作成
	 * クラスおよび匿名クラスのコーディングをしなくても処理を記述できる。
	 */
	private final InterCaluclate plus = (MessageObject mo) -> {
		return new study.lambda.Answer(mo.getFirst() + mo.getSecond());
	};

	private final InterCaluclate minus = (MessageObject mo) -> {
		return new study.lambda.Answer(mo.getFirst() - mo.getSecond());
	};

	private final InterCaluclate division = (MessageObject mo) -> {
		return new study.lambda.Answer(
				Float.valueOf(mo.getFirst()) / Float.valueOf(mo.getSecond()));
	};

	/*
	 * マッパを利用して条件分岐をなくす。
	 * メッセージに沿った結果を返す。関数的考え。
	 */
	private final Map<String, InterCaluclate> caluclateMapper = new HashMap<String, InterCaluclate>() {
		private static final long serialVersionUID = 1L;
		{
			put("Plus", plus);
			put("Minus", minus);
			put("Division", division);
		}
	};

	/* (非 Javadoc)
	 * @see study.lambda.InterCaluclateObject#getAnswer()
	 * 演算子に沿って上記ラムダ式記載の関数メンバから答えを算出する。
	 */
	@Override
	public Answer getAnswer() {
		return caluclateMapper.get(messageObject.getOperator()).calculate(messageObject);
	}

}
