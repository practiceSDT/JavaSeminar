package study.object.advance.impl;

import study.object.advance.fw.AbsCalculator;
import study.object.advance.fw.InterAnswer;
import study.object.advance.pojo.MessageObjects;

public class Division extends AbsCalculator {

	public Division() {
		this.outputFormatType = "%f";
	}
	
	@Override
	public InterAnswer calculate(MessageObjects messageObjects) {
		return new Answer(
				Float.valueOf(messageObjects.getFirst()) / 
				Float.valueOf(messageObjects.getSecond())
				);
	}

}
