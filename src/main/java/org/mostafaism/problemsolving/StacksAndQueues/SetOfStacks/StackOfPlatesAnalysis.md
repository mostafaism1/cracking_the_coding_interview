# Problem 3.3 Stack Of Plates

- ### Statement

  - Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
    Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
    Implement a data structure SetOfStacks that mimics this.
    SetOfStacks should be composed of several stacks and should create a new stack once the previous one exceeds capacity.
    SetOfStacks. push() and SetOfStacks. pop() should behave identically to a single stack (that is, pop() should return the same values as it would if there were just a single stack).
  - FOLLOW UP:
    - Implement a function popAt ( int index) which performs a pop operation on a specific sub-stack.

- ### Solution 1

  - #### Steps

    1. Create a list of stacks.
    2. Use a counter to keep track of how many elements are in the last stack.
    3. Whenever the counter exceeds the threshhold, create a new stack, add it to the end of the list, and reset the counter.
    4. As for the follow up part, if we pop from an inner stack, then we need to move all elements above it one step down (the book calls this process **rollover**)

  - #### Analysis

    - Time

      - O(1), for all stack operations.
      - For the follow up part:
        - O(N) for pop operation.

    - Space
      - O(N)

- ### Notes

  -
