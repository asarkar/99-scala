package logic

// P47 (*) Truth tables for logical expressions (2).
// Continue problem P46 by redefining and, or, etc as operators.  (i.e. make
// them methods of a new class with an implicit conversion from Boolean.)
// not will have to be left as a object method.
//
// scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
// A     B     result
// true  true  true
// true  false true
// false true  false
// false false false

object P47:
  extension (x: Boolean)
    infix def and(y: Boolean): Boolean =
      (x, y) match
        case (true, true) => true
        case _            => false

    infix def or(y: Boolean): Boolean =
      (x, y) match
        case (false, false) => false
        case _              => true

    infix def nand(y: Boolean): Boolean =
      and.andThen(P46.not)(y)

    infix def nor(y: Boolean): Boolean =
      or.andThen(P46.not)(y)

    infix def xor(y: Boolean): Boolean =
      x != y

    infix def impl(y: Boolean): Boolean =
      (x, y) match
        case (true, b)  => b
        case (false, _) => true

    infix def equ(y: Boolean): Boolean =
      (x, y) match
        case (a, true)  => a
        case (a, false) => !a
