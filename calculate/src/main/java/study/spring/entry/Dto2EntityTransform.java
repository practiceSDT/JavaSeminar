package study.spring.entry;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Transformer;
import org.springframework.messaging.Message;

import study.spring.dto.CalculateTransaction;
import study.spring.entity.IEntity;

@MessageEndpoint
public class Dto2EntityTransform {

	@Transformer
	public Message<IEntity> tranceform(Message<CalculateTransaction> _message){
//		
////		Message<IEntity> message = MessageBuilder
////				.withPayload(_iDto)
////				.build();
//		
		return null;
//		
	}
	
}
