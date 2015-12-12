package study.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import study.spring.bean.Factory;
import study.spring.bean.ICalculator;
import study.spring.entity.CalculateData;
import study.spring.repository.ICalculateJpaRepository;

@Component
@Transactional
@Log4j
public class CalculateService {
	
	@Autowired
	private ICalculateJpaRepository iCalculateJpaRepository;

	public void parsistenceData(CalculateData _calculateData){
		
		iCalculateJpaRepository.save(_calculateData);
		log.info("Saved Data : " + _calculateData);
	}
	
	public void calculateData(CalculateData _calculateData){

		CalculateData calculateData = iCalculateJpaRepository.findOne(_calculateData.getId());
		StringBuilder sb = new StringBuilder();
		log.info("Found Data : " + calculateData);
		log.info("Operator : " + calculateData.getCalculateOperator());
		ICalculator iCalculator = Factory.create(calculateData);
		
		log.info("Answer : " + iCalculator.calculate(calculateData));
		sb.append("Headder : " + calculateData.getId() + " & " + calculateData.getReceivedDate())
		.append(" ")
		.append("Answer : " + iCalculator.calculate(calculateData));
		System.out.println(sb);
				
	}
	
	public List<CalculateData> allDataFetch(){

		List<CalculateData> calculateDatas = iCalculateJpaRepository.findAll();
		log.info("Fetched Count : " + calculateDatas.size());
		
		return calculateDatas;
	}

	
}
