# Problem 4.8 First Common Ancestor

- ### Statement

  - Design an algorithm and write code to find the **first common ancestor** of two nodes in a binary tree. **Avoid** storing additional nodes in a data structure.
  - NOTE: This is not necessarily a binary search tree.

- ### Solution 1

  - #### Steps

    1. A recursive algorithm will work best here.

       - Why?
       - Because a tree is a **recursive data structure**, and it is usually the case that the most clear and expressive way to write an algorithm on a recursive data structure is by using a **recursive algorithm**.

    2. Assume that the 2 nodes are guaranteed to exist in the tree.

    3. Base cases:

       1. node = node1 or node == node2 ---> return node.
       2. if node is leaf ---> return empty-node/null.

    4. Recursive step:
       - Recursively call the function on the left child, return the result if it is not null, otherwise recursively call the function on the right child and return its result.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(H)

- ### Notes

  -
