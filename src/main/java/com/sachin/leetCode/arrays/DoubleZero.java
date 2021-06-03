package com.sachin.leetCode.arrays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class DoubleZero {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Deque<Character> ls = new  <Character>();
    ls.removeLast();
    int[] arr = {9, 9, 9, 4, 8, 0, 0, 3, 7, 2, 0, 0, 0, 0, 9, 1, 0, 0, 1, 1, 0, 5, 6, 3, 1, 6, 0, 0,
        2, 3, 4, 7, 0, 3, 9, 3, 6, 5, 8, 9, 1, 1, 3, 2, 0, 0, 7, 3, 3, 0, 5, 7, 0, 8, 1, 9, 6, 3, 0,
        8, 8, 8, 8, 0, 0, 5, 0, 0, 0, 3, 7, 7, 7, 7, 5, 1, 0, 0, 8, 0, 0};
    // int[] arr = {1,5,2,0,6,8,0,6,0};
    // int[] arr ={1,0,2,0,4};
    System.out.println(arr.length);
    Arrays.stream(arr).forEach(a -> System.out.print(a + ","));
    System.out.println();
    duplicateZeros3(arr);
    Arrays.stream(arr).forEach(a -> System.out.print(a + ","));

  }

 

  public static void duplicateZeros(int[] arr) {
    if (arr == null || arr.length == 0)
      return;
    Queue<Integer> queue = new LinkedList<Integer>();
    int current = 0;
    for (int i = 0; i < arr.length; i++) {
      queue.add(arr[i]);
      current = queue.poll();
      arr[i] = current;
      if (current == 0) {
        if (++i >= arr.length) {
          break;
        }
        queue.add(arr[i]);
        arr[i] = current;
      }
    }
  }

  public static void duplicateZeros2nd(int[] arr) {
    if (arr == null || arr.length == 0)
      return;
    int numberOfZeros = 0;
    int length = arr.length;
    boolean skipFirst = false;
    for (int i = 0; i < length - numberOfZeros; i++) {

      if ((numberOfZeros + i + 1) == length) {
        if (arr[i] == 0) {
          skipFirst = true;
        }
        break;
      }
      if (arr[i] == 0) {
        numberOfZeros++;
      }
    }
    System.out.println("Zeros - " + numberOfZeros + "- isFirst - " + skipFirst);
    int current = length - 1;
    for (int i = length - numberOfZeros - 1; i >= 0; i--, current--) {
      arr[current] = arr[i];
      if (skipFirst) {
        skipFirst = false;
        continue;
      }
      if (arr[i] == 0 && current > i) {
        arr[--current] = 0;
      }
    }
  }
  
  public static void duplicateZeros3(int[] arr) {
    int zeroCount = 0;
    int endIndex = -1;
    for (int i = 0; i < arr.length - 1 - zeroCount; i++) {
      if (arr[i] == 0) {
        zeroCount++;
        endIndex = i;
      }
    }

    System.out.println("zeros - " + zeroCount + " endIndex - " + endIndex);

    for (int i = arr.length - 1 - zeroCount; i >= 0; i--) {
      if (arr[i] != 0 || i > endIndex) {
        arr[i + zeroCount] = arr[i];
      } else {
        int pos2 = i + zeroCount - 1;
        arr[i + zeroCount] = arr[i];
        arr[pos2] = arr[i];
        zeroCount--;
      }
    }
  }

  public static void duplicateZeros4th(int[] arr) {
    if (arr == null || arr.length == 0)
      return;
    int numberOfZeros = 0;
    int length = arr.length;
    boolean skipFirst = false;
    for (int i = 0; i < length - 1 - numberOfZeros; i++) {
      if (arr[i] == 0) {
        numberOfZeros++;
      }
    }
    System.out.println("Zeros - " + numberOfZeros + "- isFirst - " + skipFirst);
    int current = length - 1;
    for (int i = length - numberOfZeros - 1; i >= 0; i--, current--) {
      arr[current] = arr[i];
      if (skipFirst) {
        skipFirst = false;
        continue;
      }
      if (arr[i] == 0 && current > i) {
        arr[--current] = 0;
      }
    }
  }

}
