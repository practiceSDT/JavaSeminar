package study.lambda;

import lombok.Getter;

@Getter
public class MessageObject {

	private final Integer first;
	private final String operator;
	private final Integer second;
	
	/**
	 * @param first
	 * @param operator
	 * @param second
	 * @param calculater
	 */
	public MessageObject(Integer first, String operator, Integer second) {
		this.first = first;
		this.operator = operator;
		this.second = second;
	}
	
}
