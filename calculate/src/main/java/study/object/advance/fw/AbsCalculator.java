package study.object.advance.fw;

import lombok.Getter;
import study.object.advance.pojo.MessageObjects;
import study.object.advance.fw.InterAnswer;

public abstract class AbsCalculator {
	
	@Getter
	protected String outputFormatType;
	
	@Getter
	protected InterAnswer answer;
	
	@Getter
	protected InterMessageText messageText;
	
	public abstract InterAnswer calculate(MessageObjects messageObjects);
}
