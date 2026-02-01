package com.java8.Character;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UncommonElements {
    public static void main(String[] args) {
        int arr1[] = {1, 2, 3, 4, 5};
        int arr2[] = {2, 3, 6, 7, 5};

        // Find elements in arr1 that are not in arr2
        List<Integer> uncommonInArr1 = Arrays.stream(arr1)
                .filter(x -> Arrays.stream(arr2).noneMatch(y -> y == x))
                .boxed()
                .collect(Collectors.toList());
         System.out.println();
         
        // Find elements in arr2 that are not in arr1
        List<Integer> uncommonInArr2 = Arrays.stream(arr2)
                .filter(x -> Arrays.stream(arr1).noneMatch(y -> y == x))
                .boxed()
                .collect(Collectors.toList());

        System.out.println();
        // 1 way
        // Combine the two lists of uncommon elements
        List<Integer> uncommonElements = IntStream.concat(
                uncommonInArr1.stream().mapToInt(Integer::intValue),
                uncommonInArr2.stream().mapToInt(Integer::intValue))
                .boxed()
                .collect(Collectors.toList());
        
        // Print all uncommon elements
        uncommonElements.forEach(System.out::println);
        System.out.println("------------------");
       
        // 2 way
        
        int[] uncommonElementsArray = IntStream.concat(
                uncommonInArr1.stream().mapToInt(Integer::intValue),
                uncommonInArr2.stream().mapToInt(Integer::intValue))
                .sorted().toArray();
        System.out.println(Arrays.toString(uncommonElementsArray));
        
       
        
        
   // 3 ways
        uncommonInArr1.retainAll(uncommonInArr2);
        System.out.println(uncommonElements);
        
        
        
        
    }
}
