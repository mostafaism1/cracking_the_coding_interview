# Problem 1.3 URLify

- ### Statement

  - Write a method to replace all spaces in a string with '%20'. You may assume that the string has sufficient space at the end to hold the additional characters,and that you are given the "true" length of the string.
  - Note: If implementing in Java, please use a character array so that you can perform this operation in place.

- ### Solution 1

  - #### Steps

    1. Compute the number of spaces in the array.
    1. Compute the displacement:

    - `displacement = spaces * 2`

    1. Iterate backwards through the array, if `current element != ''` move it forward by `displacement` amount, otherwise replace with '%20' and decrement `displacement` by 2.

  - #### Analysis

    - Time

      - O(S)

    - Space
      - O(1)
