package study.lambda;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class CaluclateObject implements InterCaluclateObject {

	@Getter
	private final MessageObject messageObject;

	private final InterCaluclate plus = (MessageObject mo) -> {
		return new study.lambda.Answer(mo.getFirst() + mo.getSecond());
	};

	private final InterCaluclate minus = (MessageObject mo) -> {
		return new study.lambda.Answer(mo.getFirst() - mo.getSecond());
	};

	private final InterCaluclate division = (MessageObject mo) -> {
		return new study.lambda.Answer(mo.getFirst() - mo.getSecond());
	};

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
	 */
	@Override
	public Answer getAnswer() {
		return caluclateMapper.get(messageObject.getOperator()).calculate(messageObject);
	}

}
