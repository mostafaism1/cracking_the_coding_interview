# Problem 3.4 Queue Via Stacks

- ### Statement

  - Implement a MyQueue class which implements a queue using two stacks.

- ### Solution 1

  - #### Steps

    1. Adding to a Queue should be done at the end (tail).
    2. to simulate this effect using a stack, we need to pop all elements from the stack, storing them on a temp stack.
    3. Push our element (making it the bottom element on the stack).
    4. Fianlly we push the original elements on the temp stack to the original stack.

  - #### Analysis

    - Time

      - O(N) for adding.
      - O(1) for all other operations.

    - Space
      - O(N)

- ### Notes

  -
