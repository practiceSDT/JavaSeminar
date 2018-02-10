package study.object.base;

public class Division extends AbsCalculater {

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
