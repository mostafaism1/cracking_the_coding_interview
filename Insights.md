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

7. Use **standard names**, for example:

- When you want to have nested iterations over a linked list, you should call the outer iteration variable `current` and the inner variable `runner`.
- For recursive helper functions, if you need to create a custom return type, then you can add the prefix **Partial**, ex. `PartialSum`. You can also name the variable with the result of the recursive step using the same prefix.

8. Use both **bounded type parameters** and **wildcard bounded type parameters** to make your APIs more flexible.

   - This advice actually comes from **Joshua Bloch**.

9. For recursive algorithms, information/data flows up the stack through input parameters, and down the stack through the return **value** (notice value is **singular**).

   - This is useful to know, especially when you want to pass multiple values down the stack, in which case, you must create a wrapper class that encapsulates all the values you want to return.

10. Traversing a singly linked list backwards, can be achieved through the use of a stack, or alternatively a recursive algorithm (which is basically a stack of function calls), at the cost of O(N) space.

11. Related to the previous point (Point 10), a stack can be used to implement a recursive algorithm **iteratively**.

12. Use **private static** inner classes to represent types that are only used by your class, and instances of the inner class are not associated with your outer class (hence the **static** keyword, ex:

- A very common use case is when defining a helper recursive function with a custom return type (to return multiple values).

12. Use the **runner approach** in linked list problems, here's the explanation from the CTCI book:

    > The runner technique means that you iterate through the linked list with **two pointers simultaneously**, with one **ahead** of the other. The "fast" node might be ahead by a fixed amount, or it might be hopping multiple nodes for each one node that the "slow" node iterates through.
    > For example, suppose you had a linked list a 1 - >a2 -> ••• ->an - >b1 ->b2 -> ••• ->bn and you wanted to rearrange it into a1 ->b1 ->a2 - >b 2 -> ••• - >an - >bn. You do not know the length of the linked list (but you do know that the length is an even number).
    > You could have one pointer pl (the fast pointer) move every two elements for every one move that p2 makes. When pl hits the end of the linked list, p2 will be at the midpoint. Then, move pl back to the front and begin "weaving" the elements. On each iteration, p2 selects an element and inserts it after pl.

13. Queues are especially useful for the following 2 use cases:

    1. Breadth-first search.
    2. Implementing a cache.

14. Use the same best practises on Test classes and Test methods that you use for regular classes and methods.
    An example would be sharing test cases between 2 different implementations of the same interface, this can be achieved through placing the common test cases in an abstract class with a `protected` field of the interface type, each implementation's test class would then extend this abstract class and instantiate the protected field to its concrete type in a @BeforeEach.

15. On why Trees & Graphs are more complicated than other **linearly** organized datastructures (i.e. Array, LinkedList, Stack, Queue):

    1. **Searching** is more complicated.
    2. Worst and Average case time **may vary widely**, and we **must** evaluate **both** aspects for any algorithm.

16. Whenever you have 2 variables of the same **reference** type and the 2 variables are pointing to the same object initially, then changing one of those variables (i.e. re-pointing it to another object) **DOES NOT** change (i.e. re-point) the other one.

    - This one might seem obvious, but you will get it wrong surprisingly often, so let this be a reminder :).

17. Replace any `Map<T, Boolean>` with a `Set<T>`.

18. Use a `Set` instead of a `List` whenever these **2** conditions are met:

    1. The **Order** of elements is un-important.
    2. **Duplicate** elements are dis-allowed.

19. Do create **abstractions** that are meaningful at the problem's domain level, instead of relying on the language's low level structures/types (int/String/List/Set/etc.), create your own structures and abstractions.

Note: You can think of this as **embedding** the problem's domain language inside the programming language of your choice, leading to a **DSL** that is at an **appropriate level** for the problem.

20. When testing a method, document your testing strategy, and include the following:

    1. Testing strategy:
       1. Input space partitions
       2. Type of coverage of the partitions' sub-domains:
          1. Cross product
          2. sub-domains
    2. Comment each test case to indicate which sub-domain of each partition it covers.

21. Related to the previous point, partitioning the input space when testing a method, leads to better test cases and better coverage.

22. To come up with a **recursive** solution, you have to employ **wishful** thinking, which basically means to use **inductive reasoning** and to divide the solution into a **base case** and a **recursive step**.

23. Many algorithms require that you create a frequancy map, use `Collections.frequancy(Collection<?> c, Object o)` to simplify the frequancy calculation.

24. Use `List.copyOf​(Collection<? extends E> coll)` instead of `new ArrayList<>(oldList)` whenever you want to create a new copy of a list from another list (or any other collection).

25. Immutability can make your life alot easier, specially when designing recursive functions.
    Unfortunately, most Java data structures are not immutable, and you will have to manually create a copy of your data structure whenever you want to mutate it, a good option is to use a **persistent data structure** library, such as **pcollections**.

26. In a fori loop, sometimes you want to perform an operation on `i-1`, at the begining of the loop's body, this can be refactored to a better design by moving the operation at the end of the loop's body and replacing `i-1` with `i`.

    - This practise is better, not only because it is clearer, but also because it eliminates the guard condition that `i - 1 > 0`.

27. A good technique for debugging, is **root-cause analysis**, which basically lets you zoom in into the specific cause for a problem.

28. Use static typing to its fullest, so that your code becomes clear and self documenting, ex:

    - Use the most specific type possible (see point 18).
    - Declare variables/method parameters as `final` (i.e. **immutable**) whenver possible.

29. Prefer if, else if, else to a sequence of ifs for a set of **mutually exclusive** conditions; This is because the if, else if, else are:

    1. **Self documenting** the mutual exclusion property.
    2. **Self documenting** the **relative order** of the conditions.
    3. A single logical unit that can be interpreted to perform a more abstrat functionality than the individual conditions that compose it. (i.e. The total is greater than the sum of its parts.)

30. Prefer writing methods that contain no blank lines; If you need to divide the method into multiple logical units with blank lines in-between, then the method is probably too long, and handles multiple responsibilities, in which case you should think about a redesign/refactoring.

    - In fact, Uncle Bob talks about this in his series clean coders episode 3, at 28:35, the gist of what he says is the following:
      1. What is a **large** function?
         > A large function is a **scope**, that scope is **divided** into different areas of functionalities, usually seen as major **indentations**. Those different sections communicate with each other using **variables** that are local to the entire scope.
      2. What do you have when you have a set of variables in long scope, accessed by many different segments of functionality?
         > A **class**. In fact, long function can almost always be refactored into one or more classes.

31. Prefer **independent** partitions when partitioning the input space for a method.

    - When partitioning the input space for a method (for the purpose of unit testing), if one partition is **dependent** on another partition, remove one of the two partitions.

32. Instead of using setters with a boolean return that indicates success/failure, prefer to design your setters with void return and optionally throwing an exception on failure.

33. Prefer the **null object pattern** to nulls.

    - Apply the **singleton pattern** along with the **null object pattern**.
    - Provide a static factory method from the interface to get the singleton instance.

34. Your first line of attack when solving a problem, is to design its **method's signature**, this lets you **parametrize** the problem in terms of inputs and output **types**.

35. 2 very important design patterns for **recursive data types**, are the **composite pattern** and the **interpreter pattern**.
    [Check this illuminating reading from MIT 6.031 Software Construction course, on the design of recursive data types](https://web.mit.edu/6.031/www/sp21/classes/16-recursive-data-types/)

36. Why is OO useful?

    - The most famous answer is that OO is useful because it is really good at **modeling** problems.
    - Uncle Bob also adds the following amazing insight:
      > OO is useful because it allows us to design programs where the **souce code dependencies** oppose the **flow of control**.
      - This is useful because it allows us to **de-couple** our low level modules from our high level modules, therefore, we can change our one module without needing to re-compile or re-deploy the other module.
      - OO achieves this through **polymorphism** (also called **polymorphic dispatch**).
      - Polymorphism is implemented by having an abstract type (interface/abstract class), and one or more concrete implementations of that type.
      - This is also called plugin architecture.
      - An advantage of this plugin architecture, is independent devlopability of the application by different teams.

37. Prefer command **query separation (CQS)**

38. Always seek to generalize your solutions; **Generics** are instrumental for achieving that goal.
