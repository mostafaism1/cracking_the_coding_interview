# Problem 4.1 Route Between Nodes

- ### Statement

  - Given a **directed** graph, design an algorithm to find out whether there is a
    route between two nodes.

- ### Solution 1

  - #### Steps

    1. The problem statement did not specify finding a **shortest** path, so we are free to use any search algorithm.

       1. **depth-first**
       2. **breadth-first**
       3. **bidirectional-search**

    2. Nevertheless, I will use **breadth**-first-search to force the search to look for the shortest path.

    3. Because I have already implemented these search algorithms, I can re-use them here;
       The algorithm will proceed as follows:
       1. Instantiate a BreadthFirstSearch, and call its search method passing in the source as the startNode, and an isFound that tests if a node == destination.
       2. Based on the result of step 1, return either true or false.

  - #### Analysis

    - Time

      - O(N)

    - Space

      - O(N)

    - where N is the number of nodes.

- ### Notes

  - This algorithm will look for the shortest path between the source and destination nodes.
