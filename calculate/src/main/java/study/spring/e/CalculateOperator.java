package study.spring.e;

import lombok.EnumId;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum CalculateOperator {
	
	PLUS("PLUS"),
	MINUS("MINUS"),
	DIV("DIV");
	
	@EnumId
	@Getter
	private final String code;
}
