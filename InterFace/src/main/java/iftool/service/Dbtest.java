package iftool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iftool.entity.ExcelInterfaceDesignFile;
import iftool.repository.ExcelInterfaceDesignFileRepository;

@Component
@Service
@Transactional
public class Dbtest implements IntDbtest {
	
	@Autowired
	ExcelInterfaceDesignFileRepository excelInterfaceDesignFileRepository;

//	@ServiceActivator
	/* (non-Javadoc)
	 * @see iftool.service.IntDbtest#run(java.lang.String)
	 */
	@Override
	public void run(String st) throws Exception {
		ExcelInterfaceDesignFile c = excelInterfaceDesignFileRepository.save(
				new ExcelInterfaceDesignFile(8,st));
		System.out.println(c + "is created");
		excelInterfaceDesignFileRepository.findAll().forEach(System.out::println);
	}
}
