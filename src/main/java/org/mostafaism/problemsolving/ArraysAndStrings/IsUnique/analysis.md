# Problem 1.1

- ## Statement

  1. Implement an algorithm to determine if a string has all unique characters.
  1. What if you cannot use additional data structures?

- ## Brain storming

  - ### part 1

    - #### Solution 1

      - #### Steps

        1. Create a Set<Character>, that will hold all the characters seen so far.
        2. Iterate over the string's characters, and check that !set.contains\(c).

      - #### Analysis

        - Time

          - O(N)

        - Space
          - O(N)

  - ### part 2

    - #### Solution 2

      - #### Steps

        1.  Sort the string.
        2.  Iterate over the string's characters,
            and check s.chartAt(i) != s.charAt(i-1), where i ranges from 1 to s.length -1.

      - #### Analysis

        - Time
          - O(N\*lg(N))
        - Space
          - O(1)
