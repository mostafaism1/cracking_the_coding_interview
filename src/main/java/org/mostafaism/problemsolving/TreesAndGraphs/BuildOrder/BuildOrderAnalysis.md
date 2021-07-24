# Problem 4.7 Build Order

- ### Statement

  - You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the second project is dependent on the first project). All of a project's dependencies must be built before the project is. Find a build order that will allow the projects to be built. If there is no valid build order, return an error.

  - EXAMPLE
    - Input:
      - projects: a, b, c, d, e, f
      - dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
    - Output: f, e, a, b, d, c

- ### Solution 1

  - #### Steps

    1. Create a graph representation for the projects and their dependencies.

    2. Check that the graph does not contain any cycles, otherwise throw an exception.

    3. Get all nodes with no **in-coming** edges.

    4. Create a new list to hold the result.

    5. Iterate over the nodes of the previous step, for each one, traverse the node and append the visited nodes to the front of the result list.

    - Note:

      1. Append to the front of the result list, because newly traversed nodes **could** be higher up the tree, and never lower down.

      2. Take care to mark the visited nodes, so that traversals do not visit them again.

  - #### Analysis

    - Time

      - O(N)

        1. Step 1: O(N)
        2. Step 2: O(N)
        3. Step 3: O(N)

        - Note:
          - **In-general**, a graph with n nodes can have O(N^2) edges, however, we know that before this step the graph is guaranteed to be **acyclic**, therefore the maximum number of edges is O(N).

        4. O(1)
        5. O(N)

    - Space

      - O(N)

- ### Notes

  - The name for this problem is called **togological sort**.
  - The book provides **2** solutions:
    1. using BFS
    2. using DFS
  - You should check the book's solutions as it goes into more depth and explains the algorithms more clearly.
