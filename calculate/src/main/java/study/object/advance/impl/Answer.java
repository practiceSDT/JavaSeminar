package study.object.advance.impl;

import study.object.advance.fw.InterAnswer;

public class Answer implements InterAnswer {

	private final Object answer;
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
