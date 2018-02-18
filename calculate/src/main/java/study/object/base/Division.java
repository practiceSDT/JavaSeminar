package study.object.base;

public class Division extends AbsCalculator {

	public Division() {
		this.outputFormatType = "%f";
	}
	
	@Override
	public InterAnswer calculate(MessageObject messageObjects) {
		return new Answer(
				Float.valueOf(messageObjects.getFirst()) / 
				Float.valueOf(messageObjects.getSecond())
				);
	}

}
