# Problem 1.1 Is Unique

- ### Statement

  1. Implement an algorithm to determine if a string has all unique characters.
  1. What if you cannot use additional data structures?

- ### Solution 1

  - #### Steps

    1. Create a Set<Character> to hold all the characters in the string.
    2. Check that the size of the set equals the length of the string.

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

  - If str.length() > charset.size(), you can automatically return false.
  - You can reduce the space usage by a factor of 8 by replacing Set<Characters> (or char[]) with a bit vector (you can use an int as the bit vector i.e. 32 bits, assuming only 'a'-'z' characters are allowed).
  - Keep in mind, if the **char_set_size** is a constant then the space complexity is actually O(1) not O(S).
