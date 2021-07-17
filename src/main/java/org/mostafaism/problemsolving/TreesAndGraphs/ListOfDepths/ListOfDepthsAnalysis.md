# Problem 4.3 List of Depths

- ### Statement

  - Given a binary tree, design an algorithm which creates a linked list of all the nodes
    at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

- The main challenge for this problem is in **tracking the depth of a node** as we perform a search (depth-first/breadth-first).

- ### Solution 1 (Modified Depth-First Search)

  - #### Steps

    1. Create a helper function that takes 2 additional parameters of type List<List<BinaryTreeNode<E>>> and int.
       (the first is the partial result, and the second is the depth)

    2. Base case

       - node is empty/null ---> return.

    3. Recursive step
       - modify the partial result by adding the node to the list for the current depth.
       - recursively call the helper function for the node's left and right children with depth = depth +1.
         (Note: Take care to create the inner list if it is not already created)

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(N)

- ### Solution 2 (Modified Breadth-First Search)

  - #### Steps

    1. Note that at any given instance, the queue will only contain nodes from 2 different depths. Therefore we need to track 2 numbers, depthLowElementCount and depthHighElementCount.

    2. On dequeue, decrement depthLowElementCount.

    3. On enqueue, increment depthHighElementCount.

    4. When depthLowElementCount = 0, set depthLowElementCount = depthHighElementCount, and depthHighElementCount = 0.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(N)

- ### Notes

  -
