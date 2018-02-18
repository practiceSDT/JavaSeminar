package study.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;

import lombok.extern.java.Log;
import study.object.base.Answer;

/**
 * 
 * @author mitsuik
 *
 */
@Log
public class LambdaBinaryOperationMod {

	public static void main(String[] args) {
		
		Integer first = 3;
		Integer second = 2;
		
		List<MessageObject> messageObjects = 
				Arrays.asList(
						new MessageObject(first, "Plus", second)
						, new MessageObject(first, "Minus", second)
						, new MessageObject(first, "Division", second)
						);
		
//		List<InterAnswer> caluclators =
			messageObjects
			.stream()
			.map(m -> new CaluclateObject(m))
			.map(c -> new MessageText(c))
			.collect(Collectors.toList())
			.stream()
			.forEach(m -> m.getPrintMessage());
		
		
		
//		messageText = new MessageText(messageObjects, calculator, answer);

//		System.out.println(messageText.getPrintMessage());
}
	
public static final Collector<Answer, ?, List<Answer>> TO_MESSAGELIST;
	static {
		Supplier<List<Answer>>           supplier    = ()       -> new ArrayList<>(10);
		BiConsumer<List<Answer>, Answer> accumulator = (l, t)   -> l.add(t);
		BinaryOperator<List<Answer>>     combiner    = (l1, l2) -> {
			l1.addAll(l2);
			return l1;
		};
		TO_MESSAGELIST = Collector.of(supplier, accumulator, combiner, Characteristics.IDENTITY_FINISH);
	}

}
