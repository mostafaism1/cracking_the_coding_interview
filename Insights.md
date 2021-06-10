# Insights

- Insights I gained by going through these problems.

---

1. Brainstorm multiple solutions, using both **focused** mode and **diffuse** mode, until you reach an optimal solution.

2. **Naming** things gives you power over them, because once you name something you have abstracted out its details; You can hold the idea solely through its name instead of its details therefore it requires **less mental stack** to think about and manipulate it in your mind.

   - This is where the power of **functions** come from; A function is essentially a **name**, i.e. an **abstraction**, therefore it's essential that you be able to extract functions out of lengthy sections of code, and give them a meaningful and clear name.

   - If you stick to this principle you'll find that your functions have a single responsibility (the responsibility being what the name says it does) and are short, making your code clearer, more readable, and maintainable.

   - A useful technique to use when you are still un-clear about how to implement something is to write a function declaration with an empty body (or returning a default value for the return type), this allows you to move on to implementing other functionality that make use of the function, and implementing the function later.

   - Another useful technique when you are reading/debugging a piece of code that you do not understand is to carve it up into multiple functions with meaningful names.

   - Note: This principle also applies to other programming constructs such as variables/constants and classes.

3. Use **functional programming** (Streams in Java 8) for the following operations:

- Map
- Filter
- Reduce
- Collect (i.e. mutable reduction)

4. Prefer **pure** functions that maps its inputs to outputs with zero side effects whenever possible, even at the cost of performance.
   (In **most** situations a constant factor increase in time is not be noticeable)
   (Gains from side-effect free code will more than pay up for the performance hit with better readability, maintainability and extensibility)

- Exceptions: in-place algorithms require mutation.

5.
