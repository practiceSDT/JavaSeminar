package InterFace.sbi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import InterFace.sbi.domain.ExcelInterfaceDesignFile;
import InterFace.sbi.repository.ExcelInterfaceDesignFileRepository;

@Service
@Transactional
@Component
@ConfigurationProperties(prefix = "service", ignoreUnknownFields = false)
public class ExcelDao implements IntDao {
	
	@Autowired
	ExcelInterfaceDesignFileRepository excelInterfaceDesignFileRepository;
	
	@Value("${prefix.filetype}")
	String filetype;

//	@ServiceActivator
	/* (non-Javadoc)
	 * @see iftool.service.IntDbtest#run(java.lang.String)
	 */
	@Override
	public void createRow(Integer id, String st) throws Exception {
		ExcelInterfaceDesignFile c = excelInterfaceDesignFileRepository.save(
				new ExcelInterfaceDesignFile(id,st,filetype));
		System.out.println(c + "is created");
		excelInterfaceDesignFileRepository.findAll().forEach(System.out::println);
	}
}
