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

  - #### Analysis

    - Time

      - O(NxM)

    - ## Space
      - O(N+M)
