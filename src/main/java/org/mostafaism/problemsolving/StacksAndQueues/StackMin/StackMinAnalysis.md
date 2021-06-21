# Problem 3.2 Stack Min

- ### Statement

  - How would you design a stack which, in addition to push and pop, has a function min
    which returns the minimum element? Push, pop and min should all operate in 0(1) time.

- ### Solution 1

  - #### Steps

    1. Note that we cannot simply add a field that tracks the min for the whole stack, because once we pop that element we wouldn't be able to track the current min.

    2. Therefore, each node in the stack has to keep track of the min for all elements below it.

    3. To achieve this we add a new field `min` to the node data structure.

  - #### Analysis

    - Time

      - O(1), all stack operations run in constant time.

    - Space
      - O(N).

- ### Notes

  - This problem is simple enough; I won't go through the implementation.
