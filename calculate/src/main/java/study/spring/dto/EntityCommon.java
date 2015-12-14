package study.spring.dto;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class EntityCommon {
	
	String uuid;
	Long timeStamp;
	
	public String getTimeStamp(){
		return convertLong2DateFormat(this.timeStamp);
	}
	
	private String convertLong2DateFormat(Long _timeStamp){

//		LocalDate localDate = LocalDate.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
//		String stringLocalDate = localDate.format(dateTimeFormatter);
		
		Instant instant = Instant.ofEpochMilli(_timeStamp);
		OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, ZoneOffset.of("+00:00"));
		return offsetDateTime.format(dateTimeFormatter);
		
	}

}
