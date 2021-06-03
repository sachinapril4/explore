package com.sachin.array;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;

public class StringSamples {

  
  public static void main(String[] args) {
    // print1stNonRepeatedChar("sachinshcinrmara");

    // reverseStringItr("nehatiwari");

    // reverseStringRec("sachin");

    // checkifAnagrams("strtr", "rtsrt");

    /* Print rotations */
    Scanner sc = new Scanner(System.in);
    System.out.println("start reversing");

    int count = sc.nextInt();
    for (int i = 0; i < count; i++) {
      printRotations(sc.nextLine());
    }
    System.out.println("Done reversing");
    sc.close();
    // readString();
  }

  

  private static void readString() {
    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    System.out.println(count);
    sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
    String s = sc.nextLine();
    System.out.println(s);
    System.out.println("Done");
    sc.close();
  }

  

  private static void printRotations(String str1) {
    char[] strArr = str1.toCharArray();
    int length = strArr.length;
    char[][] rotations = new char[length][length];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
        rotations[j][(i + j >= length ? i + j - length : i + j)] = strArr[i];
        if (i == length - 1) {
          System.out.println(rotations[j]);
        }
      }
    }
  }

  

  private static void print1stNonRepeatedChar(String str) {
    HashMap<Character, Integer> charCount = new LinkedHashMap<>();
    for (Character ch : str.toCharArray()) {
      charCount.compute(ch, (k, v) -> v == null ? 1 : ++v);
    }

    charCount.entrySet().forEach((c) -> System.out.println(c.getKey() + ":" + c.getValue()));
    Optional<Entry<Character, Integer>> result = charCount.entrySet().stream().filter(c -> (c.getValue() == 1))
        .findFirst();
    if (result.isPresent()) {
      System.out.println(result.get().getKey());
    } else {
      System.out.println("Everything is duplicate");
    }
    // System.out.println((result.isPresent() ? result.get().getKey() : "Everything is duplicate"));
  }

  

  private static void reverseStringItr(String str) {
    char[] arr = str.toCharArray();
    char tmp;
    int length = str.length();
    for (int i = 0, j = length - 1; i < length / 2; i++, j--) {
      tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
    }

    System.out.println(new String(arr));
  }

  

  private static void reverseStringRec(String str) {
    char[] arr = str.toCharArray();
    reverse(arr, 0, arr.length - 1);
    System.out.println(new String(arr));
  }

  

  private static void reverse(char[] arr, int startIndex, int lastIndex) {
    if (lastIndex <= startIndex) {
      return;
    }
    char tmp = arr[startIndex];
    arr[startIndex] = arr[lastIndex];
    arr[lastIndex] = tmp;
    reverse(arr, ++startIndex, --lastIndex);
  }

  

  private static void checkifAnagrams(String str1, String str2) {
    if (str1 == null || str2 == null || str1.length() != str2.length()) {
      System.out.println("String are not anagrams");
      return;
    }

    Map<Character, Integer> charCount = new HashMap<>();
    char[] charArray1 = str1.toCharArray();
    char[] charArray2 = str2.toCharArray();
    int value;
    boolean anagrams = true;
    char tmpChar;
    for (int i = 0; i < charArray1.length; i++) {
      tmpChar = charArray1[i];
      value = charCount.getOrDefault(tmpChar, 0);
      if (value == -1) {
        charCount.remove(tmpChar);
      } else {
        charCount.put(tmpChar, ++value);
      }

      // charCount.compute(charArray1[i], (k, v) -> v == null ? 1 : ++v);
      tmpChar = charArray2[i];
      value = charCount.getOrDefault(tmpChar, 0);
      if (value == 1) {
        charCount.remove(tmpChar);
      } else {
        charCount.put(tmpChar, --value);
      }
    }

    // for (char ch : str2.toCharArray()) {
    // value = charCount.getOrDefault(ch, 0);
    // if (value == 0) {
    // anagrams = false;
    // break;
    // } else if (value == 1) {
    // charCount.remove(ch);
    // } else {
    // charCount.put(ch, --value);
    // }
    // }

    anagrams = anagrams && charCount.isEmpty();

    if (anagrams) {
      System.out.println(str1 + " and " + str2 + " are anagrams");
    } else {
      System.out.println("String are not anagrams");
    }
  }
}
