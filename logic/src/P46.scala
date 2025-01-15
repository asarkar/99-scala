package logic

// P46 (**) Truth tables for logical expressions.
// Define functions and, or, nand, nor, xor, impl, and equ (for logical
// equivalence) which return true or false according to the result of their
// respective operations; e.g. and(A, B) is true if and only if both A and B
// are true.
//
// scala> and(true, true)
// res0: Boolean = true
//
// scala> xor(true. true)
// res1: Boolean = false
//
// A logical expression in two variables can then be written as a function of
// two variables, e.g: (a: Boolean, b: Boolean) => and(or(a, b), nand(a, b))
//
// Now, write a function called table2 which prints the truth table of a
// given logical expression in two variables.
//
// scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
// A     B     result
// true  true  true
// true  false true
// false true  false
// false false false

object P46:
  def not(x: Boolean): Boolean =
    x == false

  def table2(f: (x: Boolean, y: Boolean) => Boolean): List[(Boolean, Boolean, Boolean)] =
    for
      a <- List(true, false)
      b <- List(true, false)
    yield (a, b, f(a, b))
