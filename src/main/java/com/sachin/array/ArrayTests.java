package com.sachin.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTests {

  public static void main(String[] args) {
    // char[] chars = { 'a', 'b', 'c', 'd' };
    char[] chars = {'a', 'b', 'c'};
    // char[] chars = { 'a', 'b' };
    findPermutations(chars).forEach(System.out::println);

  }

  private static List<char[]> findPermutations(char[] chars) {
    List<char[]> permutations = new ArrayList<char[]>();
    for (int i = 0; i < chars.length; i++) {
      if (i == 0) {
        // permutations.add(String.valueOf(chars[i]));
      } else {
        permutations = calculatePermutations(chars[i], permutations);
      }
    }
    return permutations;
  }

  private static List<char[]> calculatePermutations(char ch, List<char[]> perms) {
    List<char[]> tempPermutations = new ArrayList<char[]>();
    char[] tmp;
    perms.forEach(p -> {
      // tmp = new char[p.length + 1];
      // tmp.
      // tempPermutations.add();
      // tempPermutations.add(p + ch);
    });
    return tempPermutations;
  }

}
