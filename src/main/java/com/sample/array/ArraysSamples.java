package com.sample.array;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.ConsoleHandler;

public class ArraysSamples {

  public static void main(String[] args) {
    testModulus();
    /* Max product */
    // int[] array = { 7, -7, 3, -6, -8, 5, 7 };
    // maxProduct(array);

    /* Move zero's to end */
    // int[] arrayZero = { 0, 8, 0, 3, 0, -7, 5, 8 };
    // moveZerosToEnd(arrayZero);

    /* Move zero's to end and Preserve order */
    // int[] arrayZero1 = { 0, 8, 0, 3, 0, -7, 5, 8 };
    // moveZerosToEndAndPreserveOrder(arrayZero1);

    /* findIfTwoStringsAreRotations */
    // findIfTwoStringsAreRotations("GeeksforGeeks", "eksforGeeksGe");

  }
  
  private static void testModulus() {
    System.out.println(9/10);
    System.out.println(17%10);
  }

  private static void findAllPermutationsOfAList(List<Integer> nums) {
    Set<String> permutations = new HashSet<>();
    int size = nums.size();

    for (int i = 0; i < size; i++) {

    }
  }

  private String[] findPermutations(int a, int b) {
    String[] arr = new String[2];
    arr[0] = a + "" + b;
    arr[1] = b + "" + a;
    return arr;
  }

  private static void findIfTwoStringsAreRotations(String str1, String str2) {
    boolean rotations = true;
    if (str1 == null || str2 == null || str1.length() != str2.length()) {
      rotations = false;
    }
    if (rotations) {
      char[] first = str1.toCharArray();
      char[] second = str2.toCharArray();
      boolean start = false;
      List<Integer> indexes = new ArrayList<Integer>();
      char c = first[0];
      int index = 0;

      for (char ch1 : second) {
        if (c == ch1) {
          start = true;
          indexes.add(index);
        }
        index++;
      }

      if (start) {
        int otherIndex;
        int length = first.length;
        // start = false;
        boolean found = true;
        for (int j : indexes) {
          start = true;
          for (int i = 0; i < length; i++) {
            otherIndex = i + j;
            if (otherIndex >= length) {
              otherIndex = otherIndex - length;
            }
            if (first[i] != second[otherIndex]) {
              start = false;
              break;
            }
          }
          if (start) {
            break;
          }

        }
      }

      if (start) {
        System.out.println("Strings are rotations");
      } else {
        System.out.println("Strings are not rotations");
      }
    }
  }

  private static void moveZerosToEndAndPreserveOrder(int[] arrayZero) {
    System.out.println("\n***** moveZerosToEndAndPreserveOrder *****");
    int lastIndex = arrayZero.length;
    int zeroCount = 0;
    for (int i = 0; i < lastIndex; i++) {
      if (arrayZero[i] == 0) {
        zeroCount++;
      } else if (zeroCount > 0) {
        arrayZero[i - zeroCount] = arrayZero[i];
        arrayZero[i] = 0;
      }
    }
    Arrays.stream(arrayZero).forEach(System.out::print);
  }

  private static void moveZerosToEnd(int[] arrayZero) {
    int lastIndex = arrayZero.length - 1;
    for (int i = 0; i < arrayZero.length && i < lastIndex; i++) {
      lastIndex = swapAndreturnLastIndex(arrayZero, i, lastIndex);
    }
    Arrays.stream(arrayZero).forEach(System.out::print);
  }

  private static int swapAndreturnLastIndex(int[] arr, int index, int lastIndex) {
    int tmp;
    if (arr[index] == 0) {
      tmp = arr[index];
      arr[index] = arr[lastIndex];
      arr[lastIndex] = tmp;
      lastIndex--;
      lastIndex = swapAndreturnLastIndex(arr, index, lastIndex);
    }
    return lastIndex;
  }

  private static void maxProduct(int[] array) {
    int firstMaxPos = 0, secondMaxPos = 0, firstMaxNeg = 0, secondMaxNeg = 0;
    boolean init1 = false, init2 = false, init3 = false, init4 = false;
    for (int i : array) {
      if (i >= firstMaxPos) {
        init1 = true;
        secondMaxPos = firstMaxPos;
        firstMaxPos = i;
      } else if (i > secondMaxPos) {
        secondMaxPos = i;
        init2 = true;
      } else if (i <= firstMaxNeg) {
        secondMaxNeg = firstMaxNeg;
        firstMaxNeg = i;
        init3 = true;
      } else if (i < secondMaxNeg) {
        secondMaxNeg = i;
        init4 = true;
      }
    }
    System.out.println("Max +ve: " + firstMaxPos + ", 2nd Max +ve: " + secondMaxPos
        + ", 1st Max -ve: " + firstMaxNeg + ", 2nd Max -ve: " + secondMaxNeg);
    int maxProduct = 0;
    boolean maxInit = false;
    if (init1 && init2) {
      maxProduct = firstMaxPos * secondMaxPos;
      maxInit = true;
    }

    if (init3 && init4) {
      if ((firstMaxNeg * secondMaxNeg) > maxProduct) {
        maxProduct = firstMaxNeg * secondMaxNeg;
      }
      maxInit = true;
    }

    if (!maxInit) {
      if (init1) {
        if (init3) {
          if ((firstMaxPos * firstMaxNeg) > maxProduct) {
            maxProduct = firstMaxPos * firstMaxNeg;
            maxInit = true;
          }
        } else if (init4) {
          if ((firstMaxPos * secondMaxNeg) > maxProduct) {
            maxProduct = firstMaxPos * secondMaxNeg;
            maxInit = true;
          }
        }
      } else if (init2) {
        if (init3) {
          if ((secondMaxPos * firstMaxNeg) > maxProduct) {
            maxProduct = secondMaxPos * firstMaxNeg;
            maxInit = true;
          }
        } else if (init4) {
          if ((secondMaxPos * secondMaxNeg) > maxProduct) {
            maxProduct = secondMaxPos * secondMaxNeg;
            maxInit = true;

          }
        }
      }

    }
    if (maxInit) {
      System.out.println("Max product: " + maxProduct);
    } else {
      System.out.println("Less Than 2 elements");
    }

  }
}
