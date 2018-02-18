package study.object.base;

public class Plus extends AbsCalculator {

	public Plus() {
		this.outputFormatType = "%d";
	}

	@Override
	public InterAnswer calculate(MessageObject messageObjects) {
		return new Answer(messageObjects.getFirst() + messageObjects.getSecond());
	}

}
