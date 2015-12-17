package study.spring.dto;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class CalculatedAnswer implements ICalculatedAnswer {

	private String id;
	private String calculatedDate;
	private Integer answer;
	
	/* (非 Javadoc)
	 * @see study.spring.dto.ICalculatedAnswer#getCalculatedData()
	 */
	@Override
	public String getCalculatedData(){

		return "CalculatedData is : " + this.toString();
	}
	
}
