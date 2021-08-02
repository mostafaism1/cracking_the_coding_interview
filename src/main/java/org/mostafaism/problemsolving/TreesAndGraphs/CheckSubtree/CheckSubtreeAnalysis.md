# Problem 4.10 Check Subtree

- ### Statement

  - T1 and T2 are two very large binary trees, with T1 much bigger than T2. Create an
    algorithm to determine if T2 is a subtree of T1.

    - Note:
      - A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
        That is, if you cut off the tree at node n, the two trees would be identical.

- ### Solution 1

  - #### Steps

    1. A recursive solution will work best here.

    2. Base cases.

       - Both T1 and T2 are null ---> `return true`.
       - Either T1 or T2 is null ---> `return false`.

    3. Recursive step.
       1. If `root1.data == root2.data` ---> `return checkSubtree(root1.left, root2.left) && checkSubtree(root1.right, root2.right`)
       2. Otherwise ---> `return checkSubtree(root1.left, root2) || checkSubtree(root1.right, root2)`

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(H)

- ### Notes

  -
