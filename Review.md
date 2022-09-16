# Review

- Review for tricky data structures.

## Trees And Graphs

- Tree and Graph questions are rife with ambiguous details and incorrect assumptions, therefore it's necessary to understand all the different types of trees and graphs:

### Trees

1. Types

   1. Trees vs Binary Trees.

      - A binary tree is a **special** tree in which each node has **up to** two children.

   2. Binary Tree vs Binary **Search** Tree.

      - A binary search tree is a binary tree in which every node fits a specific ordering property, namely:
      - **all** left descendents <= node < **all** right descendents

   3. Balanced vs Unbalanced.

      - A clarification is in order: A balanced tree **does not** mean that the left and right subtrees are **exactly** the same height, this is actually what a **perfect tree** is, it only means that the left and right subtrees are not terribly imbalanced such that search and insertion is **O(lgN)**.

      - The **2** most common types of balanced trees are:

      1. Red-Black trees.
      2. AVL trees.

   4. Complete Binary Trees. (think **Completely** filled levels)

      - A binary tree in which every level of the tree is **fully** filled, except for perhaps **the last level**.
        To the extent that the last level is filled, it is **filled left to right**.

   5. Full Binary Trees. (think **Full** number of child nodes)

      - A binary tree in which every node has either **zero or two** children. That is **no** nodes have only one child.

   6. Perfect Binary Trees.

      - A perfect binary tree is a binary tree in which all **interior** nodes have **two children** and all **leaves** have the **same depth** or same level.

   - Acronym: **FPS-BBC** (Full, Perfect, Search, Binary, Balanced, Complete)

2. Representation

   1. Linked representation
      - Since you can reach all nodes from the root node, all you need is a TreeNode.
      - You do **not** need a Tree class that wraps the root node, it doesn't add any value or clarity.
   2. Sequential representation (i.e. Array/List).

      - The relationship between the nodes (i.e. parent and left/right children) is determined **implicitly** by their positions in the array.
      - Assume we have n nodes (0 — n-1), to find its parent and left and right children of the node at `index = i`:

        - `parent index = (i - 1) / 2`
        - `left child index = (2 * i) + 1`
        - `right child index = (2 * i) + 2`

      - Note: The sequential representation is most often used with the **Binary Heap** representation of a **Heap** data structure.

3. **Binary** Tree Traversal techniques.

   1. In-order. (Most common)
   2. Pre-order.
   3. Post-order.

   - It's important to differentiate between Traversal and Search (Depth-first and Breadth-first) techniques, traversal techniques are for listing **all** nodes in the tree, while searching is for looking up a **single** node with a certain value.
   - All traversal techniques are a form of **depth-first** search.

4. **Binary** Heaps (Min-Heaps and Max-Heaps)

   - Def. Min Heap

     - A min-heap has **2** properties:

       1. Shape property

          - A complete binary **tree** (that is, totally filled other than the rightmost elements on the last level).

       2. Heap property
          - **each node is smaller than its children**.

     - The **root**, therefore, is the **minimum** element in the tree.
     - Remember, a Heap is a **TREE**.
     - Remember, a Heap and a **Binary** Heap are the **same** thing, because a Heap must be a binary tree.

     - The way I like to think about Min/Max Heaps is by comparing them to Binary **Search** trees, and the difference is the following:
     - In Min/Max Heaps there's no relation/ordering between the values of **left and right subtree** nodes, the relation is only between a given subtree and its parent.
     - In a Binary Search Tree, however, there's a relation between the values of **left and right subtree** nodes, all nodes in the left subtree are less than the those of the right subtree.

   - Min Heap Operations

     - There are only **2** operations:

       1. insert

          1. To maintain the **first** property (**complete** tree property), we first insert the new element at the **rightmost bottom spot**.
          2. To fix the Min Heap's **second** property (i.e. each node being smaller than its children), we swap the element with its parent, until we find an appropriate spot for the element.
             (You can think of this operation as bubbling **up** the element to its correct place)

       2. extractMin
          1. Remove the root element and **swap** it with the last element in the heap (i.e. the rightmost bottom node).
             (This maintains the **first property** i.e. **complete** tree property)
          2. We then swap the new root element with one of its children (if one of the children is smaller than the element), and repeat until we find the appropriate spot for the element.
             (You can think of this operation as bubbling **down** the element to its correct place)
             (This maintains the **second property** i.e. each node being smaller than its children)

   4. Tries (**Pre-fix** Trees)

   - Stands for re-**TRIE**-val tree.
   - Is an **n-ary** tree.
   - The node values are of type **Character**.
   - There are 2 ways to denote a sequence of characters (a path through the tree) denotes a complete word:

     1. Use a special **null** `*` node (Which is a subtype of TrieNode, i.e. `TerminatingTrieNode extends TrieNode`).
     2. Use a boolean flag `terminates` within the parent node.

   - Its use case is looking up a valid **prefix** (a HashTable can only look up **complate** words not **prefixes**)

     - Ex: storing the entire English language for quick **prefix** lookup.

   - Runtime analysis:

     - O(K), where K is the length of the string/prefix.
     - Note: This is the **same** runtime as a HashTable, although we say that a HashTable is O(1), this is not entirely true, it's O(K), because it must read through all the characters of the input. (A HashTable being O(1), is only true if we assume the string length K is always less than an upper bound constant K < C)

   - Note: A **Radix Tree / Radix Trie / Compact Prefix Tree** is one type of implementation for a Trie datastructure which is **space-optimized**.
     It achieves this space optimization by **coalescing/merging** each node that is the only child with its parent.

### Graphs

1. Def.

   - A collection of nodes with edges between **some** of them.

2. Graphs vs Trees

   - A Tree is a special type of graph, with the following properties:
     1. Connected
     2. Acyclic

3. Properties

   - Graphs have **3** properties

     1. Directed vs Undirected
     2. Connected vs Disconnected
     3. Cyclic vs Acyclic

     - Acronym: **CDC** (i.e. Center for Disease Control) (Connected, Directed, Cyclic)

4. Representation

   - **2** representations

     1. Adjacency list. (Most common)
     2. Adjacency Matrix.

     - Note:

       - The same graph algorithms used on an adjacency list can be performed with adjacency matrices, but they may be somewhat **less efficient**.
       - This is because in an adjacency list representation you can **easily obtain the neighbours of a node**.
       - While in an adjacency matrix representation you will need to **iterate over all the nodes** to identify a node's neighbours.

     - Note:
       - Unlike a tree, a graph can be disconnected, which means you cannot reach all nodes starting from a root node.
       - Therefore to represent a graph you need to store all the graph nodes in a collection (Array, list).
       - A **wrapping Graph class** is very useful to store this collection of nodes.

5. Searching

   - **3** techniques

     1. Depth-first (DFS)
        - The implementation is straightforward and uses recursion.
     2. Breadth-first (BFS)
        - More tricky, as the algorithm is **NOT** recursive and is actually **iterative**.
        - It relies on a **queue** data structure to properly **order** when nodes are visited.
     3. Bi-directional
        - Is used to find the **shortest path** between a source and destination node.
        - Operates by running **2 simultaneous BFS**, one from each node, a path is found when the 2 searches collide.
        - Is faster than BFS, specifically O(Sqrt(BFS)).
        - Runtime analysis
          - Assuming every node has at most k adjacent nodes, and the shortest path from node s to t has length d.
          - BFS: O(K^d)
          - Bi-directional: 2\*K^(d/2) -> O(K^d/2)

   - Note: Since a tree is a graph, these search techniques also apply to trees.
   - Note: Tree **traversal** techniques are actually a form of Depth-first search.
     The difference is that in a graph depth-first search we have to check if a node has **already been visited** to avoid infinite cycles incase of a cyclic graph.
