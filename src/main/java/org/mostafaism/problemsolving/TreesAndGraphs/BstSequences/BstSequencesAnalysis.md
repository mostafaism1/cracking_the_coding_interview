# Problem 4.9 BST Sequences

- ### Statement

  - A binary search tree was created by traversing through an array from left to right and inserting each element. Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.

  - Example

    - Input: root = 2, left = 1, right = 3.
    - Output: {2, 1, 3}, {2, 3, 1}

- ### Solution 1

  - #### Steps

    1. A recursive solution will work best.

    2. Note that the function's return type should be `Set<List<Integer>>`.

    3. Base cases:

       - node is empty ---> return a Set containing an empty List.
       - node is leaf ---> return a Set containing single element List with that node's value.

    4. Recursive step:

       - Recursively call on the left sub-tree.
       - Recursively call on the right sub-tree.
       - Return a List whose elements are Lists with their **first** element the root's value, and the **rest** of their values are one of the possible **interleavings** of an inner list from the left sub-tree result and an inner list from the right sub-tree result, for all inner lists of the left and right sub-tree result.

  - #### Analysis

    - Time

      - O()

    - Space

      - O()

    - Note:
      - The recurrence relation is very challenging to come up with, therefore, I will omit the analysis for this problem.

- ### Notes

  - This problem took me about 3 days, I got stuck into trying to optimize the time and space complexity, which led me to search for a persistent data structures library (specifically collections) for Java.
    Using a persistent collection data structure has an **amortized** time and space complexity of O(1).
    I found a library called [pcollections](https://www.javadoc.io/doc/org.pcollections/pcollections/latest/index.html),
    however, I ended up not using it because I had already implemented the solution using the standard Java Collections, and wanted to move on to the next problem.

  - The book's author says in this problem's solution that many people struggle with this problem, and the reason for that is that this problem requires 2 different recursive algorithms, and that its difficult to keep both algorithms straight in your head.
    She then goes on to give an advice on how to deal with this complexity, and the advice being: **Trust and Focus**.

    - Trust: When you are working with one algorithm that makes use of another algorithm, trust/assume that the other algorithm works properly.
    - Focus: If you **trust** that all other independent algorithms are working properly, then this lets you **focus** on the current algorithm at hand.

  - The book does not provide a time and/or space analysis for this problem. (Which is an indication that the analysis is quite involved)
