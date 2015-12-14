package study.spring.service;

import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import study.spring.dto.ICalculatedAnswer;
import study.spring.entity.IEntity;
import study.spring.entry.IDtoCollectorGateway;

@Service
@Log4j
public class RequestReplyMessageSendService {

    @Autowired
    private IDtoCollectorGateway iDtoCollectorGateway;

    public void sendMessage(IEntity _iEntity)
    {
    	Message<IEntity> requestMessasge = MessageBuilder.withPayload(_iEntity).build();
    	log.info("Request Message : " + requestMessasge.toString());

    	Message<ICalculatedAnswer> replayMessage = iDtoCollectorGateway.collectDto(requestMessasge);
    	log.info("Reply Message : " + replayMessage.toString());
    }
}
