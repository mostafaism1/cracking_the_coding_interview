# Problem 1.8 Zero Matrix

- ### Statement

  - Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
    column are set to 0.

- ### Solution 1

  - #### Steps

    1. We must somehow pre-compute all the indices to be zero-ed, before actually zero-ing any element.
       This is to avoid contaminating the matrix.

    2. An element (i,j) will be zero-ed, if row i OR column j contains a zero.

    3. We can use 2 `Sets`, the first will record row indices that are = 0, the second will record column indices that are = 0.

    4. We'll then iterate over each set, and zero out the corresponding entire row or column.

    5. To reduce the space to O(1), we can utilize the matrix itself for our storage needs, by doing the following:

    - Perform an initial iteration to find the first (i, j) with a zero, if one exists, and then use row i and column j as our storage.

  - #### Analysis

    - Time

      - O(NxM)

    - ## Space
      - Using sets
        - O(N+M)
      - Using the matrix for storage
        - O(1)

- ### Notes
  - I implemented the O(N + M) space solution, because the O(1) solution is really **inelegant**.
