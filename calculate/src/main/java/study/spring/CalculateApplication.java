package study.spring;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

import study.spring.e.CalculateOperator;
import study.spring.entity.CalculateData;
import study.spring.service.DataBaseDataService;
import study.spring.service.RequestReplyMessageSendService;

/**
 * 
 * @author 
 * 
 * CommandLineRunnerは利用しない。テストケース利用時に以下のアノテーションで、自動起動してしまう。
 * 「@SpringApplicationConfiguration(classes = Application.class)」
 *
 */
@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
@ImportResource("integration-context.xml")
@EnableAutoConfiguration
@ComponentScan
@Log4j
public class CalculateApplication{

    @Autowired
    private RequestReplyMessageSendService messageSendService;

    @Autowired
    private DataBaseDataService dataBaseDataService;
    
    public static void main(String[] args) {
        try (ConfigurableApplicationContext ctx = SpringApplication.run(CalculateApplication.class, args)) {
        	CalculateApplication app = ctx.getBean(CalculateApplication.class);
            app.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
						512));
		
		log.info("All Data");
		dataBaseDataService.outputStoredAllData();

	}
}
