package study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import study.spring.entity.CalculateData;
import study.spring.entity.IEntity;

@Service
public class MessageSendService {

    @Autowired
    private MessageChannel inputChannel;

    public void sendMessage(IEntity _iEntity)
    {
        inputChannel.send( MessageBuilder.withPayload(_iEntity).build() );
    }
}
