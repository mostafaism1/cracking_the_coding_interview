# Problem 2.7 Intersection

- ### Statement

  - Given two (singly) linked lists, determine if the two lists intersect. Return the inter­secting node. Note that the intersection is defined based on reference, not value.That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.

- ### Solution 1 (Stacks, non-optmal space)

  - #### Steps

    1. First note that if the 2 lists intersect, then every node after the intersection point must be the equal.
    2. Iterate through each list and push elements onto a stack.
    3. compare stacks.

  - #### Analysis

    - Time

      - O(L1 + L2)

    - Space
      - O(L1 + L2)

- ### Solution 2 (Optimal)

  - #### Steps

    1. To reduce space to O(1), we need an algorithm that traverses the lists forward.
    2. The problem with traversing forward though, is that the 2 lists might not be the same length.
    3. We can solve this problem if we know the lengths of both lists, where we can start with the longer list's pointer advanced by the difference in lengths.
    4. We then compare corresponding elements for equality.

  - #### Analysis

    - Time

      - O(L1 + L2)

    - Space
      - O(1)

- ### Solution 3 (Hashtable, non-optmal space)

  - #### Steps

    1. Add the elements of one of the lists to a Hashtable
    2. Loop through the elements of the second list searching for its value in the Hashtable. 

  - #### Analysis

    - Time

      - O(L1 + L2)

    - Space
      - O(max(L1, L2))


- ### Notes

  - Before attempting this problem, I would ask the interviewer if I can assume that the 2 lists are **acyclic**.
