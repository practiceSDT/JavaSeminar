package study.spring.entry;

import java.time.Instant;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import lombok.extern.log4j.Log4j;
import study.spring.dto.EntityCommon;
import study.spring.entity.CalculateData;
import study.spring.entity.IEntity;
import study.spring.service.CalculateService;

@MessageEndpoint
@Log4j
public class ReciveDataEntry {

	
	@Autowired
	private CalculateService calculateService;
	
	@ServiceActivator
	public Message<IEntity> paarsistenceRecivedData(Message<IEntity> _message) {
		
		log.info("UUID & TIMESTAMP : " + 
				_message.getHeaders().getId() +
				" & " +
				_message.getHeaders().getTimestamp()
				);
		//TODO Check
		
		calculateService.parsistenceData(setCommonDataFromHeadder(_message));
			
		return _message;
		}

	private CalculateData setCommonDataFromHeadder(Message<?> _message){
		CalculateData calculateData = (CalculateData) _message.getPayload();

		EntityCommon entityCommon = new EntityCommon(
				_message.getHeaders().getId().toString(), _message.getHeaders().getTimestamp());
		
		calculateData.setEntityCommon(entityCommon);
		
		return calculateData;
	}
	
}
