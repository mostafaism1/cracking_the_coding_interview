# Problem 1.2 Check Permutation

- ### Statement

  - Given two strings, write a method to decide if one is a permutation of the
    other.

- ### Solution 1

  - #### Steps

    1. Check str1.length() == str2.length().
    2. Create a frequancyMap<Character, Integer>.
    3. Iterate over str1 and increment frequancyMap\(c).
    4. Iterate over str2, check frequancyMap.contains\(c), and decrement frequancyMap\(c).
    5. check all values in frequancyMap are 0.

  - #### Analysis

    - Time

      - O(S)

    - Space

      - O(S)

    - Note
      - S is the length of either string, since str1.length() == str2.length().

- ### Solution 2

  - #### Steps

    1. Check str1.length() == str2.length().
    2. Sort both strings.
    3. Check that str1.charAt(i) == str2.charAt(i), for i from 0 to str1.length() -1.

  - #### Analysis

    - Time

      - O(S\*lg(S))

    - Space

      - O(1)
