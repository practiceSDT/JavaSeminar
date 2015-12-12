package study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBaseDataService {

	@Autowired
	private CalculateService calculateService;

    public void allDataBaseOut()
    {
    	System.out.println("Stored All Data");
    	calculateService.allDataFetch().forEach(System.out::println);
    }
	
}
