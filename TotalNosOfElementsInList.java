package com.java8.Character;

import java.util.Arrays;
import java.util.List;

public class TotalNosOfElementsInList 
{
  public static void main(String[] args) 
  {
	  //List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
	  List<Integer> myList = Arrays.asList(1,2,3,4,5);
	  long count =  myList.stream()
                          .count();
      System.out.println(count);  

  }
	
}
