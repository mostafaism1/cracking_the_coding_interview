# Problem 2.2 Kth To Last

- ### Statement

  - Implement an algorithm to find the kth to last element of a singly linked list.

- ### Solution 1

  - #### Steps

    1. Do an initial iteration to compute the size of the list `s`.
    2. Compute the index of the k<sup>th</sup> to last element `s-k`.
    3. Iterate over the list and return the `s-k`<sup>th</sup> element.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(1)

- ### Solution 2

  - #### Steps

    1. Step through the list with 2 pointer with the second pointer ahead by k elements.
    2. when the second pointer hits the end, the first pointer will be at the k<sup>th</sup> to last element.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(1)

- ### Solution 3 (Sub-optimal)

  - #### Steps

    - This solution requires the use of **global state** (static variable/passing by reference) and **mutation**, which is inelegant for a recursive solution.

    1. Imagine a recursive function `Node<K> kthToLast(LinkedList<K> head, int k, IntWrapper counter)`, with a base case returning null for head == null, and a recursive step of incrementing the counter and returning kthToLast on head.next OR head if counter == k.

    - Explaination: To imagine the workings of this algorithm, imagine the base-case value (i.e. null), being propagated from the top of the call stack to the bottom layers until counter == k, at which point the head (which is the kth to last node) will instead be propagated down the call stack, until it bottoms out.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(N)

- ### Notes

  - The
