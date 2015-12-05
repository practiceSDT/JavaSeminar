package InterFace.sbi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableConfigurationProperties(ServiceProperties.class)
@ImportResource("integration-context.xml")
public class InterFaceToolSpringBootAndIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterFaceToolSpringBootAndIntegrationApplication.class, args);
    }
}
