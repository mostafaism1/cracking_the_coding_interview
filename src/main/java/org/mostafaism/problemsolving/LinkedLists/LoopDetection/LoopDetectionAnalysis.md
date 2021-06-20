# Problem 2.8 Loop Detection

- ### Statement

  - Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.
    - DEFINITION
      - Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, so as to make a loop in the linked list.
    - EXAMPLE
      - Input:
        - A -> B -> C -> D -> E -> C [the same C as earlier]
      - Output:
        - C

- ### Solution 1

  - #### Steps

    - I actually came up with only the first part of the solution (i.e. detect if a linked list contains a loop), but had to look up the second part (i.e. find the start node of the loop) from the book.

    - The solution description is a bit lengthy, so I'll just give the gist of it, it's best to check the solution directly from book, on page 223.

    1. Use the runner technique with a slowRunner at a speed of 1 node/step and a fastRunner at a speed of 2 nodes/step.
    2. Iterate until they collide.
    3. Reset the slowRunner to the head.
    4. Iterate again until collision, but now with both runners at the same speed of 1 node/step.
    5. The node of collision is the first node in the loop.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(1)

- ### Notes

  -
