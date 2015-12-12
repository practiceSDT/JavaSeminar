package study.spring.bean;

import study.spring.entity.CalculateData;

@FunctionalInterface
public interface ICalculator {


  public Integer calculate(CalculateData _data);

}