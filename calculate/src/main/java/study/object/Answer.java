package study.object;

import lombok.AllArgsConstructor;


public class Answer implements IAnswer {

	private final Object answer;
	private final Class clazz;

	public Answer(Object answer) {
		super();
		this.answer = answer;
		clazz = answer.getClass();
	}

	/* (非 Javadoc)
	 * 本当はもっと丁寧にキャストなどの処理をしなければならない。
	 * @see study.object.IAnswer#getIntegerType()
	 */
	@Override
	public Integer getIntegerType() {
		return Integer.valueOf((Integer)answer);
	}
	
}
