package com.sachin.leetCode.arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

  public static void main(String[] args) {
  System.out.println(lengthOfLongestSubstringCopy("abba"));
    // TODO Auto-generated method stub
//    System.out.println(lengthOfLongestSubstring("dvdf"));
//    /"dvdf"
  }

  public static int lengthOfLongestSubstring(String s) {
    char[] arr = s.toCharArray();
    int maxLength = 0;
    Integer start = null, end = null;
    Map<Character, Integer> set = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (start == null) {
        start = i;
      }
      if (end == null) {
        end = i;
      }
      if (set.containsKey(arr[i]) && set.get(arr[i]) >= start) {
        start = set.get(arr[i]) + 1;
      }
      end = i;
      if (maxLength < end - start + 1) {
        maxLength = end - start + 1;
        System.out.println(end + ":" + start + ":" + maxLength);
      }
      set.put(arr[i], i);
    }
    return maxLength;
  }
  
  public static int lengthOfLongestSubstringCopy(String s) {
    if (s.length()==0) return 0;
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    int max=0;
    for (int i=0, j=0; i<s.length(); ++i){
        if (map.containsKey(s.charAt(i))){
            j = Math.max(j,map.get(s.charAt(i))+1);
        }
        map.put(s.charAt(i),i);
        max = Math.max(max,i-j+1);
    }
    return max;
}

}
