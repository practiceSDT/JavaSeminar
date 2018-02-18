package study.object.base;

import lombok.Getter;

public class MessageText {

	@Getter
	private final MessageObject messageObjects;
	@Getter
	private final InterAnswer answer;
	private final String formtext;

	public MessageText(MessageObject messageObjects,AbsCalculator calculator, InterAnswer answer) {
		this.messageObjects = messageObjects;
		this.answer = answer;
		this.formtext 
		= "%d %s %d = " + calculator.getOutputFormatType() + " です。";
	}
	
	public String getPrintMessage() {
		return String.format(
				formtext,
				messageObjects.getFirst(),
				messageObjects.getOperator(),
				messageObjects.getSecond(),
				answer.getCastAnswer()
				);
	
	}
	
}