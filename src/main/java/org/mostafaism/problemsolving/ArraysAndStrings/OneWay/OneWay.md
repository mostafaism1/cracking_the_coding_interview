# Problem 1.5 One Way

- ### Statement

  - There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.

  - Examples

    - Input: pale, ple
    - Output: true

    - Input: pales, pale
    - Output: true

    - Input: pale, bale
    - Output: true

    - Input: pale, bake
    - Output: false

- ### Solution 1

  - #### Steps

    1. Notice that insertion and deletions are inverses, so they're equivalent, i.e. deleting a character from str1 is equivalent to inserting that character into str2.
       Therefore there are only 2 operations: insert/delete and replace.
    2. If the 2 strings have equal lengths, then the only possible operation is a replace.
    3. If the 2 strings are 1 character different in length, then the only possible operation is a insert/delete.
    4. otherwise impossible.

  - #### Analysis

    - Time

      - O(S)

    - ## Space
      - O(1)

- ### Notes (from the book's solution)

  -
