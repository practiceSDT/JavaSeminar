package study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import study.spring.e.CalculateOperator;
import study.spring.entity.CalculateData;
import study.spring.service.DataBaseDataService;
import study.spring.service.MessageSendService;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
@ImportResource("integration-context.xml")
@EnableAutoConfiguration
@ComponentScan
public class CalculateApplication implements CommandLineRunner{

    @Autowired
    private MessageSendService messageSendService;

    @Autowired
    private DataBaseDataService dataBaseDataService;
    
    public static void main(String[] args) {
        SpringApplication.run(CalculateApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		
		messageSendService.sendMessage(
				new CalculateData(
						null,
						null,
						CalculateOperator.PLUS, 
						4, 
						3));

		messageSendService.sendMessage(
				new CalculateData(
						null,
						null,
						CalculateOperator.MINUS, 
						8, 
						2));

		messageSendService.sendMessage(
				new CalculateData(
						null,
						null,
						CalculateOperator.PLUS, 
						0, 
						511));
		
		dataBaseDataService.outputStoredAllData();

	}
}