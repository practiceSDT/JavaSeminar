package study.object.advance.impl;

import study.object.advance.fw.AbsCalculator;
import study.object.advance.fw.InterAnswer;
import study.object.advance.pojo.MessageObjects;

public class Plus extends AbsCalculator {

	public Plus() {
		this.outputFormatType = "%d";
	}

	@Override
	public InterAnswer calculate(MessageObjects messageObjects) {
		return new Answer(messageObjects.getFirst() + messageObjects.getSecond());
	}

}
