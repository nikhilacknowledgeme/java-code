package com.java8.Character;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RemoveDuplicateNumberJava8 
{
	public static boolean containsDuplicate(int[] nums) 
	{
		
	    List<Integer> list = Arrays.stream(nums)
	                               .boxed()
	                               .collect(Collectors.toList());
	    Set<Integer> set2=new HashSet();
	    Set<Integer> collect = list.stream().filter(s->!set2.add(s)).collect(Collectors.toSet());
	    System.out.println("-----"+collect);
	    Set<Integer> set = new HashSet<>(list);
	     if(set.size() == list.size()) 
	     {
	       return false;
	   
	     } 
	      return true;
	  
	}
	
	
	
	
	public static void main(String[] args) 
    {
//        List<Integer> listOfIntegers = Arrays.asList(111, 222, 333, 111, 555, 333, 777, 222);
//         
//        Set<Integer> uniqueElements = new HashSet<>();
//         
//        Set<Integer> duplicateElements = listOfIntegers.stream().filter(i -> ! uniqueElements.add(i)).collect(Collectors.toSet());
//         
//        System.out.println(duplicateElements);
//        
		
        
       /*How to find duplicate elements in a given 
        * integers list in java using Stream functions? 
        */
        //1 Ways By HashSet(Filter & Set.add())
        List<Integer> myList = Arrays.asList(1,2,3,5,2,3,4);
        Set<Integer> set = new HashSet();
        myList.stream()
              .filter(n -> !set.add(n))
              .forEach(System.out::println);
        
        // 2 Ways By EntrySet(Map & Collectors.groupingBy)
        List<Integer> collect = myList.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
        .entrySet()
        .stream()
        .filter(x->x.getValue()>1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
        System.out.println(collect);
       
        //3 Collections.frequency
        Set<Integer> collect2 = myList.stream().filter(i -> Collections.frequency(myList, i) > 1)
        .collect(Collectors.toSet());
        System.out.println(collect2);
        
        
        //4 Ways By Boxed 
        int nums[]={1,2,3,1};
        boolean repeated=containsDuplicate(nums);
        System.out.println(" Number is Repeated " +repeated );
        for(int i=0;i<nums.length;i++)
        {
           if(repeated)
           {
        	   System.out.println("Repeated Number is  "+ nums[i]);
           }
    
        }  
        }
}