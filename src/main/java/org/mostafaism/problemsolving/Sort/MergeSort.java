package org.mostafaism.problemsolving.Sort;

public class MergeSort {

  public static void mergeSort(int[] array) {
    final int[] tempArray = new int[array.length];
    mergeSort(array, tempArray, 0, array.length - 1);
  }

  public static void mergeSort(int[] array, int[] helper, int lowIndex, int highIndex) {
    if (lowIndex >= highIndex)
      return;

    final int midIndex = (lowIndex + highIndex) / 2;
    mergeSort(array, helper, lowIndex, midIndex);
    mergeSort(array, helper, midIndex + 1, highIndex);
    merge(array, helper, lowIndex, midIndex, highIndex);
  }

  public static void merge(int[] array, int[] helper, int lowIndex, int midIndex, int highIndex) {
    for (int i = lowIndex; i <= highIndex; i++) {
      helper[i] = array[i];
    }

    int lowIterator = lowIndex;
    int highIterator = midIndex + 1;
    int current = lowIndex;

    while (lowIterator <= midIndex && highIterator <= highIndex) {
      if (helper[lowIterator] <= helper[highIterator])
        array[current] = helper[lowIterator++];
      else
        array[current] = helper[highIterator++];

      current++;
    }

    int remaining = midIndex - lowIterator + 1;
    for (int i = 0; i < remaining; i++) {
      array[current + i] = helper[lowIterator + i];
    }

  }

}
