package study.spring.entry;

import java.util.HashSet;
import java.util.Optional;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
	public Message<IEntity> saveRecivedData(Message<IEntity> _message) {
		
		log.info("UUID & TIMESTAMP : " + 
				_message.getHeaders().getId() +
				" & " +
				_message.getHeaders().getTimestamp()
				);
		
		
		calculateService.saveData(takeOutDataFromHeadder(_message));
			
		return _message;
		}

	/**
	 * メッセージのヘッダからキーとタイムスタンプを取得してエンティティに設定する。
	 * 
	 */
	private CalculateData takeOutDataFromHeadder(Message<?> _message){
		//FIXME 出力形式が特定データに依存している。
		CalculateData calculateData = (CalculateData) _message.getPayload();

		//TODO Check
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        java.util.Set<ConstraintViolation<CalculateData>> result 
        = validator.validate(calculateData);
        
        Optional<java.util.Set<ConstraintViolation<CalculateData>>> resultOpt 
        	= Optional.ofNullable(validator.validate(calculateData));
        resultOpt.ifPresent(hoge -> {
        	log.error("Validate : " + hoge.toString());
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(hoge));
        });
        
//        if (!result.isEmpty()) {
//            log.error("Validate : " + result.toString());
//            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(result));
//          }
		
		EntityCommon entityCommon = new EntityCommon(
				_message.getHeaders().getId().toString(), 
				_message.getHeaders().getTimestamp());
		
		calculateData.setEntityCommon(entityCommon);
		
		return calculateData;
	}
	
}
