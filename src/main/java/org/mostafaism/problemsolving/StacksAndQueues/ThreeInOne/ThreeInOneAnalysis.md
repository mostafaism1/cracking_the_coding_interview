# Problem 3.1 Three In One

- ### Statement

  - Describe how you could use a single array to implement three stacks.

- ### Solution 1 (Fixed size stacks)

  - #### Steps

    1. Divide the array into 3 equal parts.
    2. Grow each stack in its allocated part of the array.

    - The downside of this appraoch is that, depending on the use case, some stacks could be empty (or non-full), while others are full, at which point we cannot add anymore to the full stack, even though there's free slots in the array.

  - #### Analysis

    - Time

      - O(1), all stack operations will run in constant time.

    - Space
      - O(1), the array already exist, we don't need any additional space.

- ### Solution 2 (Flexible size stacks)

  - #### Steps

    1. If we only had to implement 2 stacks, then we could simply grow the 2 stacks in opposite directions.
    2. 3 stacks, however, is more compex.
    3. The first and second stacks can grow in opposite directions starting from the 2 endpoints of the array.
    4. The third stack will start at the midpoint of the array.
    5. Whenever a clash occur, we'll shift the third stack either to the left or to the right, depending on the clash location. (the shift will be opposite to the clash location)

  - #### Analysis

    - Time

      - O(N), worst case for push.
      - O(1), for all operations except push.

    - Space
      - O(1), the array already exist, we don't need any additional space.

- ### Notes

  - I won't go through implementing the solution for this problem, and settle for just the analysis.
