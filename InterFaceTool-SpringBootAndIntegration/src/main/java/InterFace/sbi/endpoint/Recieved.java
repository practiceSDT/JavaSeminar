package InterFace.sbi.endpoint;

import org.springframework.integration.annotation.ServiceActivator;

public interface Recieved {

	void execute(Integer id, String st) throws Exception;

}