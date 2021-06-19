# Problem 2.6 Palindrome

- ### Statement

  - Implement a function to check if a linked list is a palindrome.

- ### Solution 1

  - #### Steps

    1. Iterate through the list and push every element onto a stack data structure.
    2. Perform another iteration through the list to check if each element is equal to the top of the stack, and then pop the stack.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(N)

- ### Solution 2

  - #### Steps

    1. Create a recursive helper function that takes a list as input and returns an instance of a class containing the following 2 fields:
       1. a boolean flag that indicates whether it's a palindrome.
       2. a runner node, at the current position to be checked.
    2. Call the function with the list head, and return its flag.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(N)

- ### Notes

  - We only need to compare the first half of the list to the second half of the list, however, this optimization does not improve the Big O time.
