package study.spring.entry;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import study.spring.dto.ICalculatedAnswer;
import study.spring.entity.IEntity;

@Component
public interface IDtoCollectorGateway {

	public Message<ICalculatedAnswer> collectDto(Message<IEntity> _iEntity);
	
}
