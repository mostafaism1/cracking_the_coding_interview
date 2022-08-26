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

    - I actually came up with only the first part of the solution (i.e. detect if a linked list contains a loop), but had to look up the second part (i.e. find the start node of the loop) from the below stackoverflow answer:
          - https://stackoverflow.com/a/3990650/9481968

    1. Use the runner technique with a slowRunner at a speed of 1 node/step and a fastRunner at a speed of 2 nodes/step.
    2. Iterate until they collide.
    3. Calculate the length of the loop by freezing the fastRunner and moving the slowRunner until collision.
    4. Reset both runners to the beginning of the list. 
    5. Set the speed of both runners to 1 node/step. 
    6. Advance only a single runner by the length of the loop, then start the other runner. 
    7. The node of collision is the beginning of the loop. 

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(1)

- ### Notes

  - The solution given in the book is vague. The explanation on the shared stackoverflow answer is much better.
