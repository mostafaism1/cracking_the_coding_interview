# Problem 4.8 First Common Ancestor

- ### Statement

  - Design an algorithm and write code to find the **first common ancestor** of two nodes in a binary tree. **Avoid** storing additional nodes in a data structure.
  - NOTE: This is not necessarily a binary search tree.

- ### Solution 1

  - #### Steps

    1.  A recursive algorithm will work best here.

        - Why?
        - Because a tree is a **recursive data structure**, and it is usually the case that the most clear and expressive way to write an algorithm on a recursive data structure is a **recursive algorithm**.

    2.  Recursive function's signature:

        - `<E> PartialResult<E> firstCommonAncestorHelper(BinaryTreeNode<E> root, BinaryTreeNode<E> node1, BinaryTreeNode<E> node2)`

        - where PartialResult is a container class for the following fields:

          - ```java
              private static class PartialResult<E> {
                private boolean containsNode1;
                private boolean containsNode2;
                private BinaryTreeNode<E> firstCommonAncestor;
              }
            ```

    3.  Base cases:

        1. root is empty/null ---> return PartialResult(false, false, null).

    4.  Recursive step:
        1. Recursively call the function on the left child, if its result's firstCommonAncestr is not null, then return the left child result.
        2. Recursively call the function on the right child, if its result's firstCommonAncestr is not null, then return the right child result.
        3. If the root is the first common ancestor, `return PartialResult(true, true, root)`
        4. If the root is node1, `return PartialResult(true, false, null)`
        5. If the root is node2, `return PartialResult(false, true, null)`
        6. Otherwise, `return PartialResult(false, false, null)`

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(H)

- ### Notes

  -
