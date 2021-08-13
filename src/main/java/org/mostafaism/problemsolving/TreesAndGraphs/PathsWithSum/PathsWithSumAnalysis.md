# Problem 4.12 Paths With Sum

- ### Statement

  - You are given a binary tree in which each node contains an integer value (which might be positive or negative). Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

- ### Solution 1

  - #### Steps

    - A recursive solution will work best.

    - Recursive method's signature:
      - BinaryTreeNode<Integer>, Int -> Int

    1. Base case.

       - Node is empty/null ---> 0.
       - Node is leaf.
         - value = sum ---> return 1.
         - Otherwise ---> return 0.

    2. Recursive step.

       1. Compute the number of paths starting at current node with sum = sum.

          - Recursively compute the result on the left and right children for sum = sum - node.value.
          - Add the children's results.
          - If node.value = sum, add 1.

       2. compute the number of paths starting at left with sum = sum

       3. compute the number of paths starting at right with sum = sum

       4. Add the above results.

  - #### Analysis

    - Time

      - O(N^2)

      - Recurrence relation:
        - T(N) = O(1) + 2T(N/2) + 2T(N/2)
          = O(1) + 4T(N/2)
          = 1 + 4 + 16 + ...4^lgN
          = O(4^lgN)
          = O(2^(2lgN))
          = O((2^lgN)^2)
          = O(N^2)

    - Space
      - O(H)

- ### Notes

  -
