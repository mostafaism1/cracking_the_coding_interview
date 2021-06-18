# Problem 2.4 Partition

- ### Statement

  - Write code to partition a linked list around a value x, such that all nodes less than x come before all nodes greater than or equal to x. If x is contained within the list, the values of x only need to be after the elements less than x (see below). The partition element x can appear anywhere in the "right partition"; it does not need to appear between the left and right partitions.

  - Example
    - Input:
      - 3 -> 5 -> 8 -> 5 -> 10 -> 2 -> 1 [partition= 5]
    - Output:
      - 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8

- ### Solution 1

  - #### Steps

    1. Iterate through the list comparing every element to partition.
    2. If the element is less than the partition, remove it from the list and re-add it (at the front).

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(1)

- ### Notes

  - The algorithm specified is not **stable**, but you can come up with a stable algorithm that has the same time and space complexity.
