# Problem 1.6 String Compression

- ### Statement

  - Implement a method to perform basic string compression using the counts
    of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
    "compressed" string would not become smaller than the original string, your method should return the original string. You can assume the string has only uppercase and lowercase letters (a - z).

- ### Solution 1

  - #### Steps

    1. Use 2 cursors to iterate over the string, the first cursor moves only through **different** subsequent characters, while the second cursor moves through **repeated** subsequent characters to get their reapeat count.

    2. To obtain an in-place algorith, modify the basic idea of **step 1** to work backwards through the string.

  - #### Analysis

    - Time

      - O(S)

    - Space
      - O(S) for creating a new string.
      - O(1) for an in-place algorithm.
