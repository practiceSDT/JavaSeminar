package study.spring.bean;

import study.spring.e.CalculateOperator;
import study.spring.entity.CalculateData;

public class Factory {

	public static ICalculator create(CalculateData _calculateData){

		ICalculator ret = null;

		if(_calculateData.getCalculateOperator() == CalculateOperator.PLUS){
			ret = new Plus();
		}else{
			ret = new Minus();
		}

		return ret;

	}



}
