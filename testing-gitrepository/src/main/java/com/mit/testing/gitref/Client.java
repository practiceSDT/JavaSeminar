package com.mit.testing.gitref;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mit.utils.dummy.IDummy;
import com.mit.utils.dummy.impl.Dummy;

public class Client {

	/** 文字列同士のアサーション */
	public static void assertString(String s0, String s1){
	    assert s0.equals(s1);
	}
	
	public static void main(String[] args) {
		
		IDummy tes = new Dummy();
		System.out.println(tes.helloWorld());

		
        List<Hosting> list = new ArrayList<>();
        list.add(new Hosting(6, "liquidweb.com", 80000,"20170101"));
        list.add(new Hosting(1, "linode.com", 90000,"20170201"));
        list.add(new Hosting(7, "digitalocean.com", 120000,"20170301"));
        list.add(new Hosting(12, "yahoo.com", 1000,"20170301"));
        list.add(new Hosting(3, "apache.com", 110000,"20170301"));
        list.add(new Hosting(2, "aws.amazon.com", 200000,"20170101"));
        list.add(new Hosting(5, "mkyong.com", 1,"20170401"));
        

        // key = id, value - websites
        Map<Integer, String> result1 = list.stream().collect(
                Collectors.toMap(Hosting::getId, Hosting::getName));

        System.out.println("Result 1 : " + result1);

        // key = name, value - websites
        Map<String, Long> result2 = list.stream().collect(
                Collectors.toMap(Hosting::getName, Hosting::getWebsites));

        System.out.println("Result 2 : " + result2);

        // Same with result1, just different syntax
        // key = id, value = name
        Map<Integer, String> result3 = list.stream().collect(
                Collectors.toMap(x -> x.getId(), x -> x.getName()));

        System.out.println("Result 3 : " + result3);
        
        //example 1
        Map result4 = list.stream()
                .sorted(Comparator.comparingLong(Hosting::getWebsites).reversed())
                .collect(
                        Collectors.toMap(
                                Hosting::getName, Hosting::getClass, // key = name, value = websites
                                (oldValue, newValue) -> oldValue,       // if same key, take the old key
                                LinkedHashMap::new                      // returns a LinkedHashMap, keep order
                        ));

        System.out.println("Result 4 : " + result4);
        
        //example 5
        TreeMap<String,List<Hosting>> result5 = list.stream()
                .collect(
                        Collectors.groupingBy(
                        		Hosting::getDay,
                        		TreeMap::new,
                        		Collectors.toList())
                        )
                        ;
        System.out.println("Result 5 : " + result5);	
        result5.forEach((k, v) -> System.out.println(k + listToString(v)));
        
        //example 6
        TreeMap<String,List<Hosting>> result6 = list.stream()
        		.sorted((person1, person2) -> person1.getId().compareTo(person2.getId()))
                .collect(
                        Collectors.groupingBy(
                        		Hosting::getDay,
                        		TreeMap::new,
                        		Collectors.toList())
                        );
        System.out.println("Result 6 : " + result6);	
        
        result6.forEach((k, v) -> System.out.println(k + listToString(v)));
        
        /**
         * http://waman.hatenablog.com/entry/2013/06/06/224923
         * http://waman.hatenablog.com/entry/2013/06/08/112545
         */
    	// toMap(keyMapper, valueMapper)
    	Stream<String> stream0 = Stream.of("Java", "Groovy", "Scala", "Clojure");
    	Map<String, Integer> lengthMap = stream0.collect(Collectors.toMap(s -> s, s -> s.length()));
    	    // (文字列, 文字列の長さ） のペアのマップ
    	assert lengthMap.get("Java") == 4;
    	assert lengthMap.get("Scala") == 5;

    	// toMap(keyMapper, valueMapper, merger)
    	Stream<String> stream1 = Stream.of("Java", "Groovy", "Groovy", "Scala", "Java", "Clojure", "Java");
    	Map<String, Integer> countMap = stream1.collect(Collectors.toMap(s -> s, s -> 1, (i, j) -> i + j));    // merger 使ってない・・・
    	    // (文字列, 文字列の出現数） のペアのマップ
    	assert countMap.get("Java") == 3;
    	assert countMap.get("Clojure") == 1;

    	// toMap(keyMapper, valueMapper, merger, mapSupplier)
    	Stream<String> stream2 = Stream.of("Java", "Groovy", "Scala", "Clojure", "Kotlin", "Jython", "JRuby");
//    	Map<String,String> headMap = stream2.collect(toMap(s->s.substring(0, 1), s->s, firstWinsMerger(), TreeMap::new));
    	    // (頭文字, 文字列） のペアのマップ
//    	assertString(headMap.get("J"), "Java");
//    	assertString(headMap.get("G"), "Groovy");	
    	// partitioningBy(predicate)
    	Stream<String> stream3 = Stream.of("Java", "Groovy", "Scala", "Clojure", "Kotlin", "Jython", "JRuby");
    	Map<Boolean,List<String>> jstartMap1 = stream3.collect(Collectors.partitioningBy(s->s.startsWith("J")));
    	    // "J" で始まるかどうかで分割
    	assertStringList(jstartMap1.get(true), "Java", "Jython", "JRuby");
    	assertStringList(jstartMap1.get(false), "Groovy", "Scala", "Clojure", "Kotlin");

    	// partitioningBy(prediate, collector)
    	Stream<String> stream4 = Stream.of("Java", "Groovy", "Scala", "Clojure", "Kotlin", "Jython", "JRuby");
//    	Map<Boolean,StringJoiner> jstartMap2 = stream4.collect(Collectors.partitioningBy(s->s.startsWith("J"),Collectors.toStringJoiner("/")));
    	    // "J" で始まる（or 始まらない）文字列を "/" で連結して StringJoiner として保持
 //   	assertString(jstartMap2.get(true).toString(), "Java/Jython/JRuby");
 //   	assertString(jstartMap2.get(false).toString(), "Groovy/Scala/Clojure/Kotlin");

	}
    	/** 第1引数の文字列リストと第2引数の文字列配列をリストにしたものをアサーション */
    	public static void assertStringList(List<String> list, String... ss){
    	    assert list.equals(Arrays.asList(ss));
	}
    	
    	public static String listToString(List<Hosting> hosts) {
    	
    		String crlf = System.getProperty("line.separator");
    		
    		StringBuilder stringBuilder = new StringBuilder();
    		hosts.stream().forEach(h -> stringBuilder.append(crlf + " " + h.getId() + ":" + h.getName()));
    		return stringBuilder.toString();
    	}


}
