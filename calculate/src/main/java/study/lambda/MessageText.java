package study.lambda;

import java.util.HashMap;
import java.util.Map;

public class MessageText {

	private final MessageObject messageObjects;
	private final InterAnswer answer;
	private final String formtext;
	
	private final Map<String,String> answerTypeMapper =
			new HashMap<String, String>(){
				private static final long serialVersionUID = 1L;
		{
            put("java.lang.Integer", "%d");
            put("java.lang.Float", "%f");
        }
    };

	//public MessageText(MessageObject messageObjects,InterCaluclate calculator, InterAnswer answer) {
	public MessageText(InterCaluclateObject caluclateObject) {
		this.messageObjects = caluclateObject.getMessageObject();
		this.answer = caluclateObject.getAnswer();
		this.formtext 
		= "%d %s %d = " + this.answerTypeMapper.get(answer.getClazz().getName()) + " です。";
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
