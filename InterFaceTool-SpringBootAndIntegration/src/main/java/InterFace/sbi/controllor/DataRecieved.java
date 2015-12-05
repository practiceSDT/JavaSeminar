package InterFace.sbi.controllor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import InterFace.sbi.service.IntDao;

@Controller
public class DataRecieved implements Recieved {

    @Autowired
//    @Qualifier("Dbtest")
    IntDao dbtest;
    
	/* (non-Javadoc)
	 * @see iftool.controller.Recieved#execute(java.lang.String)
	 */
	@Override
	public void execute(Integer id,String st) throws Exception {
		dbtest.createRow(id, st);
	}

}
