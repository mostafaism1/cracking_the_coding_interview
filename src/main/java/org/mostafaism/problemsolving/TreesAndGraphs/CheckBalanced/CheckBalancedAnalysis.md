# Problem 4.4 Check Balanced

- ### Statement

  - Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of **any** node never differ by more than one.

- ### Solution 1

  - #### Steps

    1. A recursive solution will work best here.

    2. The recursive function must return **2** values, a boolean value **isBalanced**, and the **maximalHeight** of its sub-tree (i.e. the tree rooted at the given node).

    3. Base case.

       - node is empty ---> return isBalanced = true, maximalHeight = 0.

    4. Recursive step.
       1. compute maximal height of left sub-tree.
       2. compute maximal height of right sub-tree.
       3. return isBalanced = left.isBalanced && right.isBalanced && Math.abs(maximalHeightLeft-maximalHeightRight) <= 1, maximalHeight = 1 + Math.Max(maximalHeightLeft, maximalHeightRight)

  - #### Analysis

    - Time

      - O(N)

        - Recurrence relation (the worst-case is degenerate tree):
          - T(N) = T(N-1) + O(1)
            = O(N)

    - Space

      - O(H), where H is the height of the tree.

- ### Notes

  -
