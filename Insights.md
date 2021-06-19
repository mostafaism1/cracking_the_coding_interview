# Insights

- Insights I gained by going through these problems.

---

1. Brainstorm multiple solutions, using both **focused** mode and **diffuse** mode, until you reach an optimal solution.

2. **Naming** things gives you power over them, because once you name something you have abstracted out its details; You can hold the idea solely through its name instead of its details therefore it requires **less mental stack** to think about and manipulate it in your mind.

   - This is where the power of **functions** come from; A function is essentially a **name**, i.e. an **abstraction**, therefore it's essential that you be able to extract functions out of lengthy sections of code, and give them a meaningful and clear name.

   - If you stick to this principle you'll find that your functions have a single responsibility (the responsibility being what the name says it does) and are short, making your code clearer, more readable, and maintainable.

   - A useful technique to use when you are still un-clear about how to implement something is to write a function declaration with an empty body (or returning a default value for the return type), this allows you to move on to implementing other functionality that make use of R function, and implementing the function later.

   - Another useful technique when you are reading/debugging a piece of code that you do not understand is to carve it up into multiple functions with meaningful names.

   - Note: This principle also applies to other programming constructs such as:
     - variables/constants: A variable's name **stands for** a value.
     - classes.: A class' name **stands for** both behaviour and state.

3. Use **functional programming** (Streams in Java 8) for the following operations:

   - Map
   - Filter
   - Reduce
   - Collect (i.e. mutable reduction)

4. Prefer **pure** functions that maps its inputs to outputs with zero side effects whenever possible, even at the cost of performance.

   - In **most** situations a constant factor increase in time is not noticeable.
   - Gains from side-effect free code will more than pay up for the performance hit with better readability, maintainability and extensibility.
   - Exceptions: in-place algorithms require mutation.

5. Whenver you're implementing a complex and confusing iterative algorithm (think multiple conditions inside the loop), try to think of a recursive algorith instead; Sometimes just thinking about a recursive algorithm with a base case and a recursive step can help you better structure your iterative algorithm along the same lines as the base case and recursive step.

6. For spatial problems (ex. rotating a matrix), which are usually 2 dimensional (but can be 3 dimensional too), utilize the principles of **linear algebra**, most importantly **Independence**:
   - i, j, k are independent.
   - Basically break down the operation (ex. rotation), into its effects on each independent co-ordinate separately, then add the effects.

- It's also very helpful to make a helper class, such as `Point`, that encapsulates the spatial co-ordinates, x, y, and z, and the operations you might want to perform, such as rotation.
  - However, note that **x maps to a column index** and **y to a row index**, so accessing your 2 dimensional array should be done like so:
    - `arr[p.y][p.x]`.

7. Use **standard names**, for example when you want to have nested iterations over a linked list, you should call the outer iteration variable `current` and the inner variable `runner`.

8. Use both **bounded type parameters** and **wildcard bounded type parameters** to make your APIs more flexible.

   - This advice actually comes from **Joshua Bloch**.

9. For recursive algorithms, information/data flows up the stack through input parameters, and down the stack through the return **value** (notice value is **singular**).
   - This is useful to know, especially when you want to pass multiple values down the stack, in which case, you must create a wrapper class that encapsulates all the values you want to return.
