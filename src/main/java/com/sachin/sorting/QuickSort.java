package com.sachin.sorting;

import java.util.Arrays;

public class QuickSort {

  public static void main(String[] args) {
    quickSort();
  }

  private static void quickSort() {
    int[] array = {6, 5, 3, 7, 2, 4, 8, 9, 0, 1};
    Arrays.stream(array).forEach(System.out::print);
    sort(array, 0, array.length - 1);
    System.out.println("\n");
    Arrays.stream(array).forEach(System.out::print);
  }

  private static int partition(int[] array, int l, int r) {
    int j = l;
    for (int i = l; i <= r - 1; i++) {
      if (array[i] < array[r]) {
        if (i != j) {
          swap(array, i, j);
        }
        j++;
      }
    }
    swap(array, j, r);
    return j;
  }

  private static void sort(int[] array, int l, int r) {
    if (l < r) {
      int pos = partition(array, l, r);
      sort(array, l, pos - 1);
      sort(array, pos + 1, r);
    }

  }

  static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
