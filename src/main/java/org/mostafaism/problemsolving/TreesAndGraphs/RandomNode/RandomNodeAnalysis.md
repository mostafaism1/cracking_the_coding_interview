# Problem 4.11 Random Node

- ### Statement

  - You are implementing a binary SEARCH tree class from scratch which, in addition to
    insert, find, and delete, has a method `getRandomNode()` which returns a random node
    from the tree. **All nodes should be equally likely to be chosen**. Design and implement an algorithm
    for getRandomNode, and explain how you would implement the **rest** of the methods.

- ### Solution 1

  - #### Steps

    - Design each node to include the **weight** of its subtree.

      - Note: The weight is defined to be the number of nodes in the subtree.

    - Operations

      1. insert

         - For each node on the path from the root to the insertion position, increment node.weight by 1.

      2. find

         - No change.

      3. delete

         - For each node on the path from the root to the given node, decrement node.weight by 1.

      4. getRandomNode
         1. Generate a random number in the range [0, node.weight).
         2. Switch on the value of the random number:
            - 0 ---> return root.
            - [1, node.left.weight] ---> recursively compute on the left branch.
            - [node.left.weight + 1, node.weight - 1] ---> recursively compute on the right branch.

  - #### Analysis

    - Time

      - O(lg(N)) for all operations.

    - Space
      - O(1) for all operations.
      - O(N) for the datastructure.

- ### Notes

  -
