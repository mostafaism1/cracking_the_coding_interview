# Problem 4.2 Minimal Tree

- ### Statement

  - Given a sorted (increasing order) array with unique integer elements, write an algo­rithm to create a binary search tree with minimal height.

- ### Solution 1

  - #### Steps

    1. A recursive solution will work best here.

    2. Create a **helper** function, with 2 additional parameters, **low** and **high**.

    3. Base case:

       - high < low ---> return an empty BinaryTreeNode / null

    4. Recursive step:
       - return a BinaryTreeNode with:
         1. data: equal to the middle element.
         2. left: equal to recursively calling the helper function on the left half of the array.
         3. right: equal to recursively calling the helper function on the right half of the array.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(lg(N))

- ### Notes

  -
