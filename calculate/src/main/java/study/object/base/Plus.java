package study.object.base;

public class Plus extends AbsCalculater {

	public Plus() {
		this.outputFormatType = "%d";
	}

	@Override
	public InterAnswer calculate(MessageObjects messageObjects) {
		return new Answer(messageObjects.getFirst() + messageObjects.getSecond());
	}

}
