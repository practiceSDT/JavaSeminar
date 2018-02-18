package study.lambda;

import java.util.HashMap;
import java.util.Map;

public class Answer implements InterAnswer {

//	private final MessageObject messageObject;
	private final Object answer;
	private final Class<?> clazz;
	private final Map<String,String> answerTypeMapper =
			new HashMap<String, String>(){
				private static final long serialVersionUID = 1L;
		{
            put("Integer.class", "%d");
            put("Flot.class", "%f");
        }
    };

	public Answer(Object answer) {
		this.answer = answer;
		clazz = answer.getClass();
	}

	/* (非 Javadoc)
	 * 本当は、桁落ちなどを考慮し、もっと丁寧にキャストなどの処理をしなければならない。
	 * @see study.object.IAnswer#getIntegerType()
	 */
	@Override
	public Object getCastAnswer() {
		return clazz.cast(answer);
	}

	@Override
	public String getOutputFormatType() {
		return answerTypeMapper.get(this.clazz.getName());
	}
	
}
