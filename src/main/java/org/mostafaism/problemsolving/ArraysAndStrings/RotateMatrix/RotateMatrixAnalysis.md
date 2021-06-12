# Problem 1.7 Rotate Matrix

- ### Statement

  - Given an image represented by an NxN matrix, where each pixel in the image is 4
    bytes, write a method to rotate the image by 90 degrees.
  - Can you do this in place?

- ### Solution 1

  - #### Steps

    1. Create a mapping function `rotate` that takes a point to its rotation.

       - It's useful to make a co-ordinate transformation, where the point p = (N/2,N/2) becomes the origin (0,0).

    2. Iterate over the matrix and copy over elements to their new positions in a new matrix.

    3. To turn the above algorithm to an in-place algorithm, we can simply change the iteration to only cover 1 quadraint, and for each point in that quadrant we perform rotations for the following points:

       - (i,j)
       - map(i,j)
       - map(map(i,j))
       - map(map(map(i,j)))

         - more succintly the points defined by: map^k(i,j), where 0 < k < 4

  - #### Analysis

    - Time

      - O(N^2)

    - Space

      - O(1)
