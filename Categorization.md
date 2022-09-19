1. Search
  - Brute force: 
    - Time: O(n^2)
    - Space: O(1)

  -  Optimize time at the cost of space (Hash Table)
    - Time: O(n)
    - Space: O(s)

  - Middle ground (sort + binary search)
    - Time: O(n * log n)
    - Space: O(1)

2. Conversion/Transformation (ex: encode a string)
  - Brute force:
    - Time: O(n)
    - Space: O(n)

  - Optimize space by doing a precomputation
    - Time: O(n)
    - Space: O(1)

3. Condition check
  - This is done by either:
    0. working directly with the input (worst case runtime)
    1. Mapping the input to a different data structure that directly contains the relevant aggregated data from the original input
    2. Modifying the input (in place) to put in a form that allows to check to be done faster.

4. Case Analysis

5. Nested Iterators with Different Steps (ex: StringCompression)

6. Geometrical (ex: matrix rotation)

7. 