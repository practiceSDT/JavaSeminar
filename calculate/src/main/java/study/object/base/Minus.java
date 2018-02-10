package study.object.base;

public class Minus extends AbsCalculater {

	public Minus() {
		this.outputFormatType = "%d";
	}
	
	@Override
	public InterAnswer calculate(MessageObjects messageObjects) {
		return new Answer(messageObjects.getFirst() - messageObjects.getSecond());
	}

}
