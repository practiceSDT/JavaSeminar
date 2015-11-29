/**
 * 
 */
package InterFace;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import InterFace.entity.ExcelInterfaceDesignFile;
import InterFace.repository.ExcelInterfaceDesignFileRepository;

/**
 * @author MIT
 *
 */
@EnableAutoConfiguration
@ComponentScan
public class App implements CommandLineRunner {

	@Autowired
	ExcelInterfaceDesignFileRepository excelInterfaceDesignFileRepository;

	@Override
	public void run(String... strings) throws Exception {
		ExcelInterfaceDesignFile c = excelInterfaceDesignFileRepository.save(
				new ExcelInterfaceDesignFile(8,"c:¥test"));
		System.out.println(c + "is created");
		excelInterfaceDesignFileRepository.findAll().forEach(System.out::println);
	}

public static void main(String[] args) {
	SpringApplication.run(App.class, args);
	}
}