package study.lambda;

import lombok.Getter;

public class Answer implements InterAnswer {

	private final Object answer;
	@Getter
	private final Class<?> clazz;

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
	
}
