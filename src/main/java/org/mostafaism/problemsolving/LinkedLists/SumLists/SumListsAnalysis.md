# Problem 2.5 Sum Lists

- ### Statement

  - You have two numbers represented by linked list, where each node contains a single digit. The digits are stored in reverse order, such that the 1 's digit is at the head of the list. Write a function that adds the two numbers and returns the sum as a linked list.
    - EXAMPLE
      - Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
      - Output: 2 -> 1 -> 9. That is, 912.
  - FOLLOW UP: Suppose the digits are stored in forward order. Repeat the above problem.
    - EXAMPLE
      - lnput:(6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
      - Output: 9 -> 1 -> 2. That is, 912.

- ### Solution 1

  - #### Steps

    - Iterate through both lists at the same time adding the corresponding nodes together and manage the carries, which is easy to do.
    - As for the follow up part, we must work backwards from the end of each list to the front (because information must propagate from )
    - The problem is that the 2 numbers may not have the same number of digits, which means the numbers from the 2 lists are not lined up properly.
    - However, this can be solved by padding the shorter list with zeros.
    - A recursive algorithm is usually very suitable for such these kinds of problems.
    - Here are the recursive algorithm steps:

      1. The recursive functions takes as input 2 lists of the same size, and outputs a new list and a carry (which taken together represent the sum).
      2. the base case occurs when the 2 lists are empty, in which case the output is:
         - an empty list.
           and
         - a zero carry.
      3. the recursive step output:

         - the concatenation of a new node with `value = (head1.value + head2.value + carry) % 10`
           and the output list of the recursive call.
           and
         - carry = ((head1.value + head2.value + carry) / 10) % 10

      4. Finally depending on the final return value, if it contains a carry, then you have to create one final node and attach it to the front of the list.

  - #### Analysis

    - Time

      - O(N)

    - Space
      - O(N)

- ### Notes (from the book)

  - You could convert each list into an int, then add them.
