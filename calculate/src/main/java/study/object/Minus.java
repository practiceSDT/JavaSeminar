package study.object;

public class Minus implements ICalculate {

	@Override
	public IAnswer calculate(MessageObjects messageObjects) {
		return new Answer(messageObjects.getFirst() - messageObjects.getSecond());
	}

}
