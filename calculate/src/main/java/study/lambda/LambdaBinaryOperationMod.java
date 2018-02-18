package study.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 
 * @author mitsuik
 *
 */
public class LambdaBinaryOperationMod {

	public static void main(String[] args) {
		
		Integer first = 3;
		Integer second = 2;
		
		/*
		 * Stream処理説明のため、配列化。
		 */
		List<MessageObject> messageObjects = 
				Arrays.asList(
						new MessageObject(first, "Plus", second)
						, new MessageObject(first, "Minus", second)
						, new MessageObject(first, "Division", second)
						);
		
		/*
		 * ラムダ式を代入した関数型インタフェースで出力部分を記載する。
		 * コントロールの処理に制御文が混じらなくなるので、理解しやすくなる。
		 * forEach(answerPrint)　answerPrintを配列要素一つ一つで処理する。ということ
		 * 設計書と自然な記載ができるようになる。理解と経験があれば。。。
		 */
		Function<MessageObject, InterCaluclateObject> createCaluclateFromMessage 
			= mo -> new CaluclateObject(mo);
		Function<InterCaluclateObject, MessageText> createMessageTextFromCaluclator 
			= ca -> new MessageText(ca);
		Consumer<MessageText> answerPrint = mt -> System.out.println(mt.getPrintMessage());
		
			messageObjects
			/*
			 * messageObjectsを入力として、
			 * messageObjectsを引数としてCaluclateObject生成し
			 * CaluclateObjectを引数としてMessageText生成し
			 * MessageTextの配列を生成し
			 * 全ての要素にanswerPrintを適用する。
			 */
			.stream()
			.map(createCaluclateFromMessage)
			/*
			 * これも依存を生み出す記載となる。
			 * 上記Mapはnewするオブジェクトが変わってもインタフェースが同じであれば、この処理には影響がない。
			 * 下記の処理は、newするオブジェクトが直値になっているので、実装を変える場合は影響を受ける可能性がある。
			 *  	.map(createMessageTextFromCaluclator)
			 *  でよい。
			 */
			.map(c -> new MessageText(c))
			.collect(Collectors.toList())
			.forEach(answerPrint);
		
	}

}
