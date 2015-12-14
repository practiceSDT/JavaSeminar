package study.spring.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;
import study.spring.ServiceProperties;
import study.spring.bean.Factory;
import study.spring.bean.ICalculator;
import study.spring.dto.CalculatedAnswer;
import study.spring.dto.ICalculatedAnswer;
import study.spring.entity.CalculateData;
import study.spring.repository.ICalculateJpaRepository;

@Component
@Transactional
@Log4j
public class CalculateService {
	
	@Autowired
	private ICalculateJpaRepository iCalculateJpaRepository;
	
	@Autowired
	private ServiceProperties configuration;

	public void saveData(CalculateData _calculateData){
		
		iCalculateJpaRepository.save(_calculateData);
		log.info("Saved Data : " + _calculateData);
	}
	
	public ICalculatedAnswer calculateData(CalculateData _calculateData){

		CalculateData calculateData = iCalculateJpaRepository.findOne(_calculateData.getId());
		ICalculator iCalculator = Factory.create(calculateData);

		//FIXME 無関係の下位問題。関心の分離
		DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime d = LocalDateTime.now();
		
		CalculatedAnswer calculatedAnswer = new CalculatedAnswer(
				calculateData.getId(),
				d.format(f),
				iCalculator.calculate(calculateData));

		StringBuilder sb = new StringBuilder();
		log.info("Found Data : " + calculateData);
		log.info("Operator : " + calculateData.getCalculateOperator());
		log.info(configuration.getAnswer() +
				configuration.getSep() + calculatedAnswer.getCalculatedData());
		sb.append("Headder : " + calculateData.getId() + " & " + calculateData.getReceivedDate())
		.append(" ")
		.append("Answer : " + calculatedAnswer.getCalculatedData());
		System.out.println(sb);
		
		return calculatedAnswer; 
				
	}
	
	public List<CalculateData> fetchAllData(){

		List<CalculateData> calculateDatas = iCalculateJpaRepository.findAll();
		log.info("Fetched Count : " + calculateDatas.size());
		
		return calculateDatas;
	}

	
}
