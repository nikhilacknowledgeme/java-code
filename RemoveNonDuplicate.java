package com.java8.Character;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveNonDuplicate 
{

	public static void main(String[] args) 
	{
	//	List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
		
		List<Integer> myList = Arrays.asList(10,15,8,49,25,10,25);
		List<Integer> collect = myList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
		        .entrySet()
		        .stream()
		        .filter(x->x.getValue()==1)
		        .map(Map.Entry::getKey)
		        .collect(Collectors.toList());
		        System.out.println(collect);	
		        
		        
		 Set<Integer> nonDuplicate = myList.stream().filter(x->Collections.frequency(myList, x)==1).collect(Collectors.toSet());       
	   System.out.println(nonDuplicate);
	}

}
