# Problem 2.3 Delete Middle Node

- ### Statement

  - Implement an algorithm to delete a node in the middle (i.e., any node but the first and last node, not necessarily the exact middle) of a singly linked list, given only access to that node.

  - Example

    - lnput:the node c from the linked lista->b->c->d->e->f
    - Result: nothing is returned, but the new linked list looks likea->b->d->e- >f

  - Note: You do not have a reference to the **head** of the list, only the node to be deleted.

- ### Solution 1

  - #### Steps

    1. We do not have access to the head or the previous node, therefore anything we will do has to be at node to be deleted or its nexts.

    2. We remove the node by copying its next node into it (i.e. copying both next.key and next.next).

  - #### Analysis

    - Time

      - O(1)

    - Space
      - O(1)
