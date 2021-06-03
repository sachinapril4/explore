package com.sachin.sorting;

public class SelectionSort {

  public static void sort(Integer[] array) {
    selectAndPlace(array.length, array);
  }

  private static void selectAndPlace(int length, Integer[] array) {
    int selectedIndex = 0;
    Integer selectedElement = null;
    if (length <= 1) {
      return;
    }
    for (int i = 0; i < length; i++) {
      if (i == 0) {
        selectedIndex = 0;
        selectedElement = array[0];
      } else if (selectedElement < array[i]) {
        selectedElement = array[i];
        selectedIndex = i;
      }
    }
    Integer tmpElement = array[length - 1];
    array[length - 1] = selectedElement;
    array[selectedIndex] = tmpElement;
    selectAndPlace(length - 1, array);
  }
}
