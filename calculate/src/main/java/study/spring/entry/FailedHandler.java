package study.spring.entry;

import javax.validation.ConstraintViolationException;

import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component
@Log4j
public class FailedHandler {

    @ServiceActivator
    public void handleFailedMessage(Exception e) {
    	if(e.getCause() instanceof ConstraintViolationException){
    		//FIXME エクセプションの中身からメッセージを取得する。
    		log.warn("Validation ERROR : " + e.getCause());
    	}else{
            log.error("Unknown ERROR : " + e);
    	}
    	
		System.exit(1);
    }
	
}
