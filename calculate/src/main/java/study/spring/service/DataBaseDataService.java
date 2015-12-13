package study.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataBaseDataService {

	@Autowired
	private CalculateService calculateService;

    public void outputStoredAllData()
    {
    	System.out.println("Stored All Data");
    	calculateService.fetchAllData().forEach(System.out::println);
    }
	
}
