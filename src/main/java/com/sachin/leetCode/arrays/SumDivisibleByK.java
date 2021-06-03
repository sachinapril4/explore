package com.sachin.leetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class SumDivisibleByK {

  public static void main(String[] args) {
    int[] arr = {-1,1,-2,2,-3,3,-4,4};
    //           -1,-1,2,2,0,1,1, 1,-2, 0
    
    
   
//    int[] arr = {-4,-7,5,2,9,1,10,4,-8,-3};
    System.out.println(canArrange(arr, 3));
  }


  public static boolean canArrange(int[] arr, int k) {
    Map<Integer, Integer> remainderMap = new HashMap<>();
    Integer remainder = null;
    Integer rRem = null;
    Integer rCount = 0;
    for (int i : arr) {
      remainder = (i % k + k) % k;
      rRem = (k - remainder) % k;
      if (remainderMap.get(rRem) != null) {
        rCount = remainderMap.get(rRem);
        rCount--;
        if (rCount == 0) {
          remainderMap.remove(rRem);
        } else {
          remainderMap.put(rRem, rCount);
        }
      } else {
        remainderMap.put(remainder, remainderMap.getOrDefault(remainder, 0) + 1);
      }
    }
    return remainderMap.isEmpty();
  }
}
