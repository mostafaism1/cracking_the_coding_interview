# Problem 3.6 Animal Shelter

- ### Statement

  - An animal shelter, which holds only dogs and cats, operates on a strictly "**first in, first out**" basis.
    People must adopt either the "oldest" (based on arrival time) of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
    They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, dequeueDog, and dequeueCat.
    You may use the built-in Linked list data structure.

- ### Solution 1

  - #### Steps

    1. The problem clearly states **first in, first out**, which should quickly steer you towards a queue data structure.
    2. The problem, however, is a bit more difficult since we have 2 different queues, cats and dogs, and we have to be able to somehow merge the 2 queues into a single queue.
    3. We could add a **timestamp** field (or alternatively a sequence number) on the nodes of both queues.
    4. When we want to dequeue, we compare timestamps on the tail elements of both queues and dequeue the one with the earlier timestamp.

  - #### Analysis

    - Time

      - O(1)

    - Space
      - O(N)

- ### Notes

  -
