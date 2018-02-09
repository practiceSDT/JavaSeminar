package study.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MessageText {

	@Setter
	@Getter
	private MessageObjects messageObjects;
	@Setter
	@Getter
	private IAnswer answer;
	private String formtext = "%d %s %d = %d です。";
	
	public String getPrintMessage() {
		return String.format(
				formtext,
				messageObjects.getFirst(),
				messageObjects.getOperator(),
				messageObjects.getSecond(),
				answer.getIntegerType()
				);
	
	}
	
}
