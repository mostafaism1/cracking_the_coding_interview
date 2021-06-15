# Problem 1.9 String Rotation

- ### Statement

  - Assume you have a method isSubstring which checks if one word is a substring of another.
    Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one call to isSubstring.

  - Example
    - "waterbottle" is a rotation of"erbottlewat"

- ### Solution 1

  - #### Steps

    1. The problem is asking for only 1 call to isSubString, therefore we have to somehow transform s2 such that s1.isSubString(s2) will be true.

    1. If s2 is indeed a rotation of s1, then concatenating s2 to itself must contain s1.

  - #### Analysis

    - Time

      - O(1) + O(isSubString)
        - O(isSubstring)
          - Naive approach: O(S^2)
          - Knuth–Morris–Pratt algorithm: O(S)

    - ## Space

      - O(S)

      - Note: S is the length of either string, since they must be equal.
