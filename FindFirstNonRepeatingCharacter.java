package com.java8.Character;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
 1)Initially an IntStream is created with input.chars().
 2)mapToObj(..) converts IntStream with primitive characters to Stream of lowercase Character objects.
 3)Function.identity() returns the input as output. i.e. x -> x. So, it returns the Character object in the stream itself.
 4)LinkedHasMap is used to maintain the order.
 5)collect(..) will convert the Stream to a Java Map.
 6)map(entry -> entry.getKey()) returns only a stream of Character keys with the count of 1. 



	    Character result = input.chars()// Stream of String       
	            .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to lower case and then to Character object stream     
	            .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
	            .entrySet()
	            .stream()
	            .filter(entry -> entry.getValue() == 1L)
	            .map(entry -> entry.getKey())
	            .findFirst()
	            .get();







 */
//IntStream---> has a method mapToObj converts primitive char type to the Character wrapper object. 
//                This method returns a type Stream


public class FindFirstNonRepeatingCharacter 
{

	public static void main(String[] args) 
	{
		
		// 1 Ways 
		String input = "Java articles are Awesome Java  are";
		
	    Character result = input.chars().peek(System.out::println).mapToObj(c->(char)c)
	    		.peek(System.out::println)
	    		.collect(Collectors.groupingBy(x->x,LinkedHashMap::new,Collectors.counting()))
	    		.entrySet().stream().filter(entry->entry.getValue()==1L)
	    		.map(entry->entry.getKey()).skip(1).findFirst().get();
	    System.out.println("Result "   +result); 
	    System.out.println("----------------");
	    
	    System.out.println("Print all Non Repeating Character ");
        
        String input1 = "Java articles are Awesome Java  are";
  	  
        input.chars() // Stream of String       
        .mapToObj(s -> (char) s) // First convert to lower case and then to Character object stream     
        .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
        .entrySet()
        .stream()
        .filter(entry -> entry.getValue() > 1L)
        .map(entry -> entry.getKey()).forEach(System.out::println);
        
        System.out.println("Reverse the Character ");
        
        String[] split = input1.split(" ");// Here Stream<String> is object
        String collect = Arrays.stream(split).map(word->new StringBuffer(word).reverse()).peek(System.out::println)
        .collect(Collectors.joining(" "));
        System.out.println("Reverse string ---->"+collect );

	}

}
