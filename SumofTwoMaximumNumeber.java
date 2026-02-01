package com.java8.Character;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumofTwoMaximumNumeber {

	public static void main(String[] args) 
	{
		 List<Integer> numbers = Arrays.asList(10, 3, 5, 4, 9, 7);
         /*IntStream --->Converts the stream of Integer objects to an IntStream
		 Integer::intValue method reference is passed to mapToInt
		  to convert each Integer to its corresponding int value.
		  Essentially, for each Integer in the stream, the intValue 
		  method is called to get its primitive int value.
		 */
		
		 // 1 Ways 
		 OptionalInt SumOfTwo = numbers.stream()
		 .mapToInt(Integer::intValue) 
         .sorted() // Sort the stream in ascending order
         .limit(2) // Limit the stream to the first two elements
		 .reduce((a,b)->a+b);
		 System.out.println(SumOfTwo);
		 
		 //2 Ways  Sum of Two Minimum Number
	Integer SumOfTwoNos = numbers.stream().sorted().limit(2).reduce(Integer::sum).get();
	System.out.println("Sum of Two Minimum Numbers  " +SumOfTwoNos);
	
	 //2 Ways  Sum of Two Maximum Number
		Integer SumOfTwoMaximuNos = numbers.stream().sorted(Collections.reverseOrder()).limit(2).reduce(Integer::sum).get();
		System.out.println("Sum of Two Maximum Numbers  " + SumOfTwoMaximuNos);
	
	
	}

}
