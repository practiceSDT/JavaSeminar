package study.spring.bean;

import study.spring.entity.CalculateData;

public class Plus implements ICalculator {

  public Integer calculate(CalculateData _data) {
	  return _data.getCalculateArg() + _data.getBeCalculatedArg();
  }
  
  
}