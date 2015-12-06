package InterFace.sbi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
@ImportResource("integration-context.xml")
@EnableAutoConfiguration
public class InterFaceToolSpringBootAndIntegrationApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(InterFaceToolSpringBootAndIntegrationApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
