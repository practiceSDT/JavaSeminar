package study.object.base;

import lombok.Getter;

@Getter
public class MessageObjects {

	private final Integer first;
	private final String operator;
	private final Integer second;
	
	/**
	 * @param first
	 * @param operator
	 * @param second
	 * @param calculater
	 */
	public MessageObjects(Integer first, String operator, Integer second) {
		this.first = first;
		this.operator = operator;
		this.second = second;
	}
	
}
