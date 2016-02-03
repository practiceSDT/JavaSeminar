package org.springframework.integration.samples.helloworld;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

public class DocTypeRouter {
	
    public String resolveObjectTypeChannel(Message<String> message) {

    	return message.getPayload().toString();
        
    }


}
