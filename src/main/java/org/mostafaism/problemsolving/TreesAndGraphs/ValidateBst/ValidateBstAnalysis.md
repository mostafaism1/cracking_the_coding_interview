# Problem 4.5 Validate BST

- ### Statement

  - Implement a function to check if a binary tree is a binary search tree.

- ### Solution 1

  - #### Steps

    1. A recursive solution will work best.

    2. Create a recursive helper function.

    3. The recursive function must return **3** values, a boolean value **isBst**, **min**, and **max**.

    4. Base case.

       - node is a leaf ---> isBst = true, min = node.data, max = node.data

       - Note: Unfortunately the case where a node = null cannot be treated as a base case, because we cannot return a meaningful min or max in such a case.

    5. Recursive step.
       1. recursively call the function on the left sub-tree.
       2. recursively call the function on the sub-tree.
       3. return
          - isBst = left.isBst && right.isBst && node.data => left.max && node.data < right.min
          - min = node.data < left.min? node.data : left.min
          - max = node.data > right.max? node.data : right.max

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(H)

- ### Notes

  - Instead of designing our helper function to return a custom class with the **3** values, **isBst**, **min**, and **max**, we can instead return a single value **isBst** and take the **max** and **min** ranges as inputs which our node's value must fall between.
    The book's solution uses this approach.

  - The book proposes another solution which uses in-order traversal to perform the validation, however, this algorithm requires that the tree's values be unique.
