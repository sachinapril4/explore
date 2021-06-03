package com.sachin.sorting;

import java.util.Arrays;

public class HeapSort {
  
  public static void main(String []args) {
    heapSort();
  }
  
  private static void heapSort() {
    Integer[] array = {6, 5, 3, 7, 2, 4, 8, 9, 0, 1};
    Arrays.asList(array).forEach(System.out::print);
    HeapSort.sort(array);
    System.out.println("\n");
    Arrays.asList(array).forEach(System.out::print);
  }

  public static void sort(Integer[] arr) {
    int n = arr.length;
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(arr, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      // Move current root to end
      int temp = arr[0];
      arr[0] = arr[i];
      arr[i] = temp;

      // call max heapify on the reduced heap
      heapify(arr, i, 0);
    }
  }

  private static void heapify(Integer[] arr, int n, int i) {
    int largest = i;
    int left = i * 2 + 1;
    int right = i * 2 + 2;

    if (left < n && arr[largest] < arr[left]) {
      largest = left;
    }

    if (right < n && arr[largest] < arr[right]) {
      largest = right;
    }

    if (largest != i) {
      int swap = arr[i];
      arr[i] = arr[largest];
      arr[largest] = swap;
      heapify(arr, n, largest);
    }
  }
}