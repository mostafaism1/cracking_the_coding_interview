# Problem 1.1 Is Unique

- ### Statement

  1. Implement an algorithm to determine if a string has all unique characters.
  1. What if you cannot use additional data structures?

- ### Solution 1

  - #### Steps

    1. Create a Set<Character> to hold all the characters seen so far.
    2. Iterate over the string's characters, and check that !set.contains\(c).

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(N)

- ### Solution 2

  - #### Steps

    1.  Sort the string.
    2.  Iterate over the string's characters,
        and check s.chartAt(i) != s.charAt(i-1), where i ranges from 1 to s.length -1.

  - #### Analysis

    - Time
      - O(N\*lg(N))
    - Space
      - O(1)

- ### Notes (from the book's solution)

  - If str.length() > charset, you can automatically return false.
  - You can reduce the space usage by a factor of 8 by replacing Set<Characters> (or char[]) with a bit vector.
