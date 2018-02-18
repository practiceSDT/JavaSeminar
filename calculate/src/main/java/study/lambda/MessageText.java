package study.lambda;

import lombok.Getter;

public class MessageText {

	@Getter
	private final MessageObject messageObjects;
	@Getter
	private final InterAnswer answer;
	private final String formtext;

	//public MessageText(MessageObject messageObjects,InterCaluclate calculator, InterAnswer answer) {
	public MessageText(InterCaluclateObject caluclateObject) {
		this.messageObjects = caluclateObject.getMessageObject();
		this.answer = caluclateObject.getAnswer();
		this.formtext 
		= "%d %s %d = " + answer.getOutputFormatType() + " です。";
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
