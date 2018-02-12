package study.object.advance.view;

import lombok.Getter;
import study.object.advance.fw.AbsCalculator;
import study.object.advance.fw.InterAnswer;
import study.object.advance.fw.InterMessageText;
import study.object.advance.pojo.MessageObjects;

public class MessageText implements InterMessageText {

	@Getter
	private final MessageObjects messageObjects;
	@Getter
	private final InterAnswer answer;
	private final String formtext;

	public MessageText(MessageObjects messageObjects,AbsCalculator calculator, InterAnswer answer) {
		this.messageObjects = messageObjects;
		this.answer = answer;
		this.formtext 
		= "%d %s %d = " + calculator.getOutputFormatType() + " です。";
	}
	
	/* (非 Javadoc)
	 * @see study.object.advance.view.InterMessageText#getPrintMessage()
	 */
	@Override
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
