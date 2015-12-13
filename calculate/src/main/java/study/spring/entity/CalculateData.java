package study.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import study.spring.dto.EntityCommon;
import study.spring.e.CalculateOperator;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CALCULATE_DATA")
public class CalculateData implements IEntity,Serializable{
	
	/**
	 * 1L
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(nullable = false)
	private String receivedDate;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private CalculateOperator calculateOperator;
	
	@Column(nullable = false)
	private int calculateArg;
	
	/**
	 * 0から10までの数値を扱う。
	 */
    @NotNull
    @Min(0)
    @Max(10)
	@Column(nullable = false)
	private int beCalculatedArg;

	@Override
	public void setEntityCommon(EntityCommon _entityCommon) {
		this.setId(_entityCommon.getUuid());
		this.setReceivedDate(_entityCommon.getTimeStamp());
		
	}
	

}
