# Problem 4.6 Successor

- ### Statement

  - Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a **binary search tree**. You may assume that each node has a **link to its parent**.

- ### Solution 1

  - #### Steps

    1. Let's start by thinking about the most straight-forward brute-force solution, which is basically doing an **in-order** traversal of the tree, and then returning the element that comes next after the given node.

    2. This works, but we are doing un-necessary work:

       1. Traversing the entire left sub-tree, which cannot contain the successor,
       2. Traversing some paths in the right sub-tree that also cannot contain the successor.

    3. To cut out this un-necessary work, we can do the following:

       1. Only traverse the right sub-tree of the given node.
       2. In the right sub-tree, for each given node, only traverse to the left, **never** to the right.

    4. I'll try to come up with a recursive solution.

    5. What should the helper recursive function's signature be?

    - Ans. the function should take a BinaryTreeNode and return its left-most node:
      - `BinaryTreeNode<E> getLeftMostNode(BinaryTreeNode<E> node)`

    6. Base case.

       - node's left child is empty/null ---> return node.

    7. Recursive step.

       - recursively call the function on the left child.

  - #### Analysis

    - Time

      - O(Lg(N)), for a balanced tree,
      - O(N) for a degenerate tree.

    - Space
      - O(1) (assuming tail call optimization)

- ### Notes

  - This algorithm does not make use of the fact that each node has a link to its parent.
