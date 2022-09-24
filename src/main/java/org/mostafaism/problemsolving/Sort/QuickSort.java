package org.mostafaism.problemsolving.Sort;

import java.util.Random;

public class QuickSort {

  public static void quickSort(int[] array) {
    quickSort(array, 0, array.length - 1);
  }

  public static void quickSort(int[] array, int lower, int higher) {
    int index = partition(array, lower, higher);
    if (lower < index - 1)
      quickSort(array, lower, index - 1);
    if (index < higher)
      quickSort(array, index, higher);
  }

  public static int partition(int[] array, int lower, int higher) {
    int pivot = new Random().nextInt(lower, higher + 1);
    int leftIndex = lower;
    int rightIndex = higher;

    while (leftIndex <= rightIndex) {
      while (array[leftIndex] <= pivot)
        leftIndex++;
      while (array[rightIndex] > pivot)
        rightIndex++;

      if (leftIndex <= rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = rightIndex;
        array[rightIndex] = temp;
        leftIndex++;
        rightIndex++;
      }
    }
    return leftIndex;
  }

}
