package org.mostafaism.problemsolving.Sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

  @Test
  void should_sort() {
    int[] input = new int[] {2, 1, 8, 5, 8, 3};
    MergeSort.mergeSort(input);
    assertArrayEquals(new int[] {1,2,3,5,8, 8}, input);
  }

}
