package iftool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import iftool.service.Dbtest;
import iftool.service.IntDbtest;

@Controller
@ComponentScan("iftool.service")
public class DataRecieved implements Recieved {

    @Autowired
//    @Qualifier("Dbtest")
    IntDbtest dbtest;
    
	/* (non-Javadoc)
	 * @see iftool.controller.Recieved#execute(java.lang.String)
	 */
	@Override
	@ServiceActivator
	public void execute(String st) throws Exception {
		dbtest.run(st);
	}

}
