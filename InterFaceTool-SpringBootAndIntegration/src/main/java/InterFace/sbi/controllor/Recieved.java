package InterFace.sbi.controllor;

import org.springframework.integration.annotation.ServiceActivator;

public interface Recieved {

	void execute(Integer id, String st) throws Exception;

}