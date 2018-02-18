package study.object.base;

import lombok.Getter;

public abstract class AbsCalculator {
	
	@Getter
	protected String outputFormatType;

	public abstract InterAnswer calculate(MessageObject messageObjects);
}
