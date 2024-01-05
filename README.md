[S-99: Ninety-Nine Scala Problems](https://aperiodic.net/phil/scala/s-99/)

[![](https://github.com/asarkar/99-scala/workflows/CI/badge.svg)](https://github.com/asarkar/99-scala/actions)

## Working with lists

[P01](src/main/scala/list/P01.scala) (*) Find the last element of a list.

[P02](src/main/scala/list/P02.scala) (*) Find the last but one element of a list.

[P03](src/main/scala/list/P03.scala) (*) Find the Kth element of a list.

[P04](src/main/scala/list/P04.scala) (*) Find the number of elements of a list.

[P05](src/main/scala/list/P05.scala) (*) Reverse a list.

[P06](src/main/scala/list/P06.scala) (*) Find out whether a list is a palindrome.

[P07](src/main/scala/list/P07.scala) (**) Flatten a nested list structure.

[P08](src/main/scala/list/P08.scala) (**) Eliminate consecutive duplicates of list elements.

[P09](src/main/scala/list/P09.scala) (**) Pack consecutive duplicates of list elements into sublists.

[P10](src/main/scala/list/P10.scala) (*) Run-length encoding of a list.

[P11](src/main/scala/list/P11.scala) (*) Modified run-length encoding.

[P12](src/main/scala/list/P12.scala) (**) Decode a run-length encoded list.

[P13](src/main/scala/list/P13.scala) (**) Run-length encoding of a list (direct solution).

[P14](src/main/scala/list/P14.scala) (*) Duplicate the elements of a list.

[P15](src/main/scala/list/P15.scala) (**) Duplicate the elements of a list a given number of times.

[P16](src/main/scala/list/P16.scala) (**) Drop every Nth element from a list.

[P17](src/main/scala/list/P17.scala) (*) Split a list into two parts.

[P18](src/main/scala/list/P18.scala) (**) Extract a slice from a list.

[P19](src/main/scala/list/P19.scala) (**) Rotate a list N places to the left.

[P20](src/main/scala/list/P20.scala) (*) Remove the Kth element from a list.

[P21](src/main/scala/list/P21.scala) (*) Insert an element at a given position into a list.

[P22](src/main/scala/list/P22.scala) (*) Create a list containing all integers within a given range.

[P23](src/main/scala/list/P23.scala) (**) Extract a given number of randomly selected elements from a list.

[P24](src/main/scala/list/P24.scala) (*) Lotto: Draw N different random numbers from the set 1..M.

[P25](src/main/scala/list/P25.scala) (*) Generate a random permutation of the elements of a list.

[P26](src/main/scala/list/P26.scala) (**) Generate the combinations of K distinct objects chosen from the N elements of a list.

[P27](src/main/scala/list/P27.scala) (**) Group the elements of a set into disjoint subsets.

[P28](src/main/scala/list/P28.scala) (**) Sorting a list of lists according to length of sublists.

## Arithmetic

[P31](src/main/scala/arithmetic/P31.scala) (**) Determine whether a given integer number is prime.

[P32](src/main/scala/arithmetic/P32.scala) (**) Determine the greatest common divisor of two positive integer numbers.

[P33](src/main/scala/arithmetic/P33.scala) (*) Determine whether two positive integer numbers are coprime.

[P34](src/main/scala/arithmetic/P34.scala) (**) Calculate Euler’s totient function ϕ(m).

[P35](src/main/scala/arithmetic/P35.scala) (**) Determine the prime factors of a given positive integer.

[P36](src/main/scala/arithmetic/P36.scala) (**) Determine the prime factors of a given positive integer (2).

P37 (**) Calculate Euler’s totient function ϕ(m) (improved).

P38 (*) Compare the two methods of calculating Euler’s totient function.

[P39](src/main/scala/arithmetic/P39.scala) (*) A list of prime numbers.

[P40](src/main/scala/arithmetic/P40.scala) (**) Goldbach's conjecture.

[P41](src/main/scala/arithmetic/P41.scala) (**) A list of Goldbach compositions.

## Logic and Codes

[P46](src/main/scala/logic/P46.scala) (**) Truth tables for logical expressions.

[P47](src/main/scala/logic/P47.scala) (*) Truth tables for logical expressions (2).

P48 (**) Truth tables for logical expressions (3).

[P49](src/main/scala/logic/P49.scala) (**) Gray code.

[P50](src/main/scala/logic/P50.scala) (***) Huffman code.

## Binary Trees

P54 Omitted; our tree representation will only allow well-formed trees.

P55 (**) Construct completely balanced binary trees.

P56 (**) Symmetric binary trees.

P57 (**) Binary search trees (dictionaries).

P58 (**) Generate-and-test paradigm.

P59 (**) Construct height-balanced binary trees.

P60 (**) Construct height-balanced binary trees with a given number of nodes.

P61 (*) Count the leaves of a binary tree.

P61A (*) Collect the leaves of a binary tree in a list.

P62 (*) Collect the internal nodes of a binary tree in a list.

P62B (*) Collect the nodes at a given level in a list.

P63 (**) Construct a complete binary tree.

P64 (**) Layout a binary tree (1).

P65 (**) Layout a binary tree (2).

P66 (***) Layout a binary tree (3).

P67 (**) A string representation of binary trees.

P68 (**) Preorder and inorder sequences of binary trees.

P69 (**) Dotstring representation of binary trees.

## Multiway Trees

P70B Omitted; we can only create well-formed trees.

P70C (*) Count the nodes of a multiway tree.

P70 (**) Tree construction from a node string.

P71 (*) Determine the internal path length of a tree.

P72 (*) Construct the postorder sequence of the tree nodes.

P73 (**) Lisp-like tree representation.

## Graphs

P80 (***) Conversions.

P81 (**) Path from one node to another one.

P82 (*) Cycle from a given node.

P83 (**) Construct all spanning trees.

P84 (**) Construct the minimal spanning tree.

P85 (**) Graph isomorphism.

P86 (**) Node degree and graph coloration.

P87 (**) Depth-first order graph traversal.

P88 (**) Connected components.

P89 (**) Bipartite graphs.

## Miscellaneous Problems

P90 (**) Eight queens problem

P91 (**) Knight’s tour.

P92 (***) Von Koch’s conjecture.

P93 (***) An arithmetic puzzle.

P94 (***) Generate K-regular simple graphs with N nodes.

P95 (**) English number words.

P96 (**) Syntax checker.

P97 (**) Sudoku.

P98 (***) Nonograms.

P99 (***) Crossword puzzle.

## Running tests

```
./.github/run.sh
```

To run all tests from a package:
```
./.github/run.sh <package prefix>
```

## License

Released under [Apache License v2.0](LICENSE).