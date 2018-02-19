package study.stream.common.factory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.extern.log4j.Log4j;
import study.stream.common.bean.City;

@Log4j
public class CityFactory {

	 private static Stream<City> createStreamCites() {
		try {
			return Files.lines(
					Paths.get(
							new File(".").getAbsoluteFile().toString() +
				    		"/src/test/resources/cities.txt"
							)
					)
			.map(l -> l.split(", "))
			.map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
		} catch (NumberFormatException | IOException e) {
			log.error("テストファイル読み込み時もしくは数字形式エラー");
			e.printStackTrace();
			return Stream.empty(); 
		} finally {
			log.info("createStreamCites end.");
		}
	}

	public static ArrayList<City> createArryListCites() {
		return createStreamCites().collect(Collectors.toCollection(ArrayList::new)); 
	}

	
}
