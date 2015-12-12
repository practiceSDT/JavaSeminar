package study.spring.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.spring.e.CalculateOperator;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CalculateTransaction {
	
	@Enumerated(EnumType.STRING)
	private CalculateOperator calculateOperator;
	
	private int calculateArg;
	
	private int beCalculatedArg;
	

}
