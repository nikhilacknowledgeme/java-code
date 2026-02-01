package com.java8.Character;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstRepeatingCharacter 
{

	public static void main(String[] args) 
	{
               //List<Integer> asList = Arrays.asList(1,2,3,4,5,2,3,4);		
		String input = "say i feel like i have been here before";       
		Set<Integer> set=new HashSet();
		 /*OptionalInt first =  input.chars()
                       .filter(i -> !set.add(i))
                       .findFirst();
                   if (first.isPresent()) 
                   {
                       System.out.println((char) first.getAsInt());
                   }
          */
		 int asInt = input.chars()
                 .filter(i -> !set.add(i))
                 .findFirst()
                 .getAsInt(); //we use this to get the primitive int value of the first found duplicate character.
         System.out.println((char)asInt); //convert int into character.
         System.out.println("------------------------------");
         
	//Given a String, find the first repeated character in it using Stream functions?
//     Character result = input.chars() // Stream of String       
//                           .mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s))) // First convert to Character object and then to lowercase         
//                           .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count 
//                           .entrySet()
//                           .stream()
//                           .filter(entry -> entry.getValue() > 1L)
//                           .map(entry -> entry.getKey())
//                           .findFirst()
//                           .get();
//                          System.out.println(result);                     
//                   
                     
         Map<Character, Long> countOfElement = input.chars().mapToObj(s->(char)s).collect(Collectors.groupingBy(e->e,LinkedHashMap::new,Collectors.counting()));
         System.out.println(countOfElement);
         Entry<Character, Long> entry2 = countOfElement.entrySet().stream().filter(s->s.getValue()>1).skip(1)
                                           .findFirst().get();         
         System.out.println(entry2);
         
                          
                          
                          String input2 = "programming in java";
                          
                          Map<Character, Integer> charCount = new LinkedHashMap<>();
                          
                          // Count frequency of each character
                          for (char c : input.toCharArray()) 
                          {
                              charCount.put(c, charCount.getOrDefault(c, 0) + 1);

                          }

                          // Find first character with count > 1
                          for (Map.Entry<Character, Integer> entry : charCount.entrySet()) 
                          {
                              if (entry.getValue() > 1)
                              {
                                  System.out.println("First repeated character: " + entry.getKey());
                                  break;
                              }
                          }


	}

}
