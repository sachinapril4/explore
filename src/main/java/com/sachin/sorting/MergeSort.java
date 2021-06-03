package com.sachin.sorting;

public class MergeSort {

  public static void sort(Integer[] array) {
    Integer[] firstHalf = null;
    Integer[] secHalf = null;
    if (array != null && array.length > 1) {
      Integer halfSize = array.length / 2;
      firstHalf = new Integer[halfSize];
      secHalf = new Integer[array.length - halfSize];
      System.arraycopy(array, 0, firstHalf, 0, halfSize);
      System.arraycopy(array, halfSize, secHalf, 0, array.length - halfSize);
      sort(firstHalf);
      sort(secHalf);
      merge(firstHalf, secHalf, array);
    }
  }

  private static Integer[] merge(Integer[] arr1, Integer[] arr2, Integer[] sortedArray) {
    Integer aLen = arr1.length;
    Integer bLen = arr2.length;
    for (int i = 0, a = 0, b = 0; i < aLen + bLen; i++) {
      if (a >= aLen) {
        sortedArray[i] = arr2[b++];
      } else if (b >= bLen) {
        sortedArray[i] = arr1[a++];
      } else if (arr1[a] > arr2[b]) {
        sortedArray[i] = arr2[b++];
      } else {
        sortedArray[i] = arr1[a++];
      }
    }
    return sortedArray;
  }
}
