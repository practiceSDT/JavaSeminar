package study.spring.entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import study.spring.dto.ICalculatedAnswer;
import study.spring.entity.CalculateData;
import study.spring.entity.IEntity;
import study.spring.service.CalculateService;

@MessageEndpoint
public class CalculateDataEntry {

	@Autowired
	private CalculateService calculateService;
	
	@ServiceActivator
	public Message<ICalculatedAnswer> calcurate(Message<IEntity> _message){
		ICalculatedAnswer iCalculatedAnswer = calculateService.calculateData((CalculateData)_message.getPayload());
		
		return MessageBuilder.withPayload(iCalculatedAnswer).build();
	}
	
}
