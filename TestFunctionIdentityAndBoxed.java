package com.java8.Character;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestFunctionIdentityAndBoxed 
{

	public static void main(String[] args) 
	{
		int arr[]={1,2,3,4,5,2,3,2,4,5,9,8,7};
	Map<Integer, List<Integer>> collect = Arrays.stream(arr)
                .boxed().collect(Collectors.groupingBy(Function.identity()));
  collect.entrySet().forEach(System.out::println);
	
	//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

  int arr1[]={1,2,3,4,5,2,3,2,4,5,9,8,7};
	Map<Integer, Long> collect2= Arrays.stream(arr1)
              .boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
	
	collect2.entrySet().forEach(System.out::println);
	
	//String str="nikhil";
	Character character = "nikhil".chars().mapToObj(ch->Character.toLowerCase(Character.valueOf((char)ch)))
	.collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
	.entrySet().stream().filter(entry->entry.getValue()==1).map(entry->entry.getKey())
	.findFirst().get();
	System.out.println(character);
	}

}
