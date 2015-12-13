package study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import study.spring.entity.IEntity;
import study.spring.entry.IDtoCollectorGateway;

@Service
public class MessageSendService {

    @Autowired
    private IDtoCollectorGateway iDtoCollectorGateway;

    public void sendMessage(IEntity _iEntity)
    {
//        inputChannel.send( MessageBuilder.withPayload(_iEntity).build() );
    	iDtoCollectorGateway.collectDto(MessageBuilder.withPayload(_iEntity).build());
    }
}
