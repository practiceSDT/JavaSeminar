package study.spring.bean;

import study.spring.entity.CalculateData;

public class Minus implements ICalculator {

	@Override
	public Integer calculate(CalculateData _data) {
		return _data.getCalculateArg() - _data.getBeCalculatedArg();
  }
  
  
}