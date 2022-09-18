1. Statement
2. Clarifying Questions
3. Test cases (Input -> Output)
4. Categorize the problem (A category is something like: Search, Optimization, Traversal...etc.) 
5. Brainstorm solutions and discuss them with the interviewer. For each solution discuss the time and space complexity (time and space tradeoffs is a better phrasing).
  - Always state the brute force approach, and optimize from there. The goal is to find the most optimal solution given the constraints.
  - Always derive the complexity, don't just state it.
    - i.e. breakdown the analysis to the analysis of the individual steps, then sum/multiply.
7. Define the entrypoint function's signature:
  1. Method name
  2. Method Parameter types
  3. Method Parameters names
  4. Method return type
8. Code the solution in the entry point function. 
9. Handle edge cases with guard clauses
10. Perform constant-factor optimizations.
11. Refactor:
  1. Use meaning names for local variables.
  2. Extract functions whenever possible.
  3. Extract class whenever possible.