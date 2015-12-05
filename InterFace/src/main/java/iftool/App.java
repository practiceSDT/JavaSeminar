/**
 * 
 */
package iftool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import iftool.controller.Recieved;
import iftool.entity.ExcelInterfaceDesignFile;
import iftool.repository.ExcelInterfaceDesignFileRepository;

/**
 * @author MIT
 *
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {

	@Autowired
	Recieved excelInterfaceDesignFileRepository;

	@Override
	public void run(String... strings) throws Exception {
		excelInterfaceDesignFileRepository.execute("c:¥test");
	}

public static void main(String[] args) {
	SpringApplication.run(App.class, args);
//		try (AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:META-INF/spring/integration/context.xml")){
//			MessageChannel channel = context.getBean("input",MessageChannel.class);
//			channel.send(MessageBuilder.withPayload("test").build());
//		}
	
	}
}