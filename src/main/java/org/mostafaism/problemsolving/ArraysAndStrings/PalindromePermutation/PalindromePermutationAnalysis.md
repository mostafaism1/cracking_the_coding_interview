# Problem 1.4 Palindrome Permutation

- ### Statement

  - Given a string, write a function to check if it is a permutation of a palin­drome. A palindrome is a word or phrase that is the same forwards and backwards. A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.

  - Example
    - Input: Tact Coa
    - Output: True (permutations: "taco cat", "atco eta", etc.)

- ### Solution 1

  - #### Steps

    1. Create a frequency map for the string's characters.
    2. If the length of the string is even, then **every** character **must** occur at an even frequency, otherwise **only 1** character **must** occur at an odd frequency.

  - #### Analysis

    - Time

      - O(S)

    - ## Space
      - O(S)

- ### Notes (from the book's solution)

  - There's no need to check the string's length then decide based on that what the odd count should be, we can just check that odd count <= 1, since it is redundant.
    (You can easily convince yourself about this).

  - We can optimize the space usage replacing the `Map<Character, Integer>` with a **bit vector**, since the only information needed is whether each character occurs at an odd or even frequency not the count.
    - **Note**: This does not change the big O space usage.
