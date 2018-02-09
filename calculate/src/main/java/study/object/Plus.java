package study.object;

public class Plus implements ICalculate {

	@Override
	public IAnswer calculate(MessageObjects messageObjects) {
		return new Answer(messageObjects.getFirst() + messageObjects.getSecond());
	}

}
