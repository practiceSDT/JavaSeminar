package study.stream.collect;

import study.stream.common.factory.CityFactory;

public class ToMapExample {

	public static void main(String[] args) {
		
		CityFactory.createArryListCites().forEach(System.out::println);
		
	}

}
