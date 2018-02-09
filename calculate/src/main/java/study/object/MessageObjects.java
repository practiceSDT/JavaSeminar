package study.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class MessageObjects {

	private final Integer first;
	private final String operator;
	private final Integer second;
	
}
