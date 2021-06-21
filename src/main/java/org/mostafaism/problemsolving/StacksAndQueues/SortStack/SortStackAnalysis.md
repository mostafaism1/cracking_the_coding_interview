# Problem 3.5 Sort Stack

- ### Statement

  - Write a program to sort a stack such that the smallest items are on the top.
    You can use an additional temporary stack, but you may **not** copy the elements into any other data structure (such as an array).
    The stack supports the following operations: push, pop, peek, and is Empty.

- ### Solution 1

  - #### Steps

    1. We only have to change the push operation, such that it inserts each element in its correct position in the stack.
    2. Given an ordered stack of length l, to push a new element e, we do the following:
       1. compare e to the top of stack (stack.peek()).
       2. If e is greater, we pop the top of the stack onto a temp stack, and repeat while the stack is not empty, otherwise push e.
       3. Push the temp stack onto the original stack.

  - #### Analysis

    - Time

      - O(N) for push.
      - O(1) for all other operations.

    - Space
      - O(N)

- ### Notes

  -
