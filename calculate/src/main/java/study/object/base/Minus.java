package study.object.base;

public class Minus extends AbsCalculator {

	public Minus() {
		this.outputFormatType = "%d";
	}
	
	@Override
	public InterAnswer calculate(MessageObject messageObjects) {
		return new Answer(messageObjects.getFirst() - messageObjects.getSecond());
	}

}
