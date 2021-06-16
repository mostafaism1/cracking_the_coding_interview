# Problem 2.1 Remove Dups

- ### Statement

  - Write code to remove duplicates from an unsorted linked list.
  - Follow up: How would you solve this problem if a temporary buffer is not allowed?

- ### Solution 1

  - #### Steps

    1. We could use a frequancy map to count how many times a value occurs, we then remove elements with count > 1 and decrement the count.
    1. If, however, we are not allowed any extra space, we'll have to resort to a naive brute force search.

  - #### Analysis

    - Time

      - Frequancy map: O(N)
      - Brute force: O(N^2)

    - Space
    - Frequancy map: O(N)
    - Brute force: O(1)

- ### Notes

  - An O(N*lgN) time O(N*lgN) space solution can be obtained by first sorting the linked list, using merge-sort.
