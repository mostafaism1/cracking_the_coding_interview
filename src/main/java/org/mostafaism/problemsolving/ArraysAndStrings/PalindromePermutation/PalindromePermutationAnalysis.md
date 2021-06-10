# Problem 1.4 Palindrome Permutation

- ### Statement

  - Given a string, write a function to check if it is a permutation of a palin­drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

  - Example
    - Input: Tact Coa
    - Output: True (permutations: "taco cat", "atco eta", etc.)

- ### Solution 1

  - #### Steps

    1. Create a frequancy map for the string's characters.
    2. If the length of the string is even, then **every** character **must** occur at an even frequancy, otherwise **only 1** character **must** occur at an odd frequancy.

  - #### Analysis

    - Time

      - O(S)

    - ## Space
      - O(S)
