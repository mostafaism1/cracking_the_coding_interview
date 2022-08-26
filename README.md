# Cracking The Coding Interview

- This repo is a record of my attempts at practising and honing my problem solving skills, implementing popular data structures, and designing, analyzing and implementing optimal algorithms.

- In addition, I try to unit test all the problems and follow TDD practices.

- The problems come from the following sources:

  - [Cracking The Coding Interview](https://www.amazon.com/Cracking-Coding-Interview-Programming-Questions/dp/0984782850/ref=sr_1_1?dchild=1&keywords=cracking+the+coding+interview&qid=1620865491&sr=8-1)

## Language

The solutions are implemented in **Java**.

## Structure

- Problems are grouped in directories by topic, such as **ArraysAndString**, **LinkedLists**, etc.
- Each problem is placed in it's own directory, named after the problem in **PascalCase**, and containing the following files:
  - {ProbleName}Analysis.md
    - Lists the optimal solution(s), followed by a detailed algorithmic analysis.
  - {ProblemName}.java
    - Contains the following entries:
      - public method(s), named after the class, implementing the solution(s) proposed in {ProbleName}Analysis.md.
        - **Note**: In the case of more than 1 optimal solution, the methods are postfixed with the same index as the solution proposed in {ProbleName}Analysis.md.
      - Helper classes (whenever extra classes lead to clearer and more modular design).
