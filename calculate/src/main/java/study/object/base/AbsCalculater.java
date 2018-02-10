package study.object.base;

import lombok.Getter;

public abstract class AbsCalculater {
	
	@Getter
	String outputFormatType;
	
	abstract InterAnswer calculate(MessageObjects messageObjects);
}
