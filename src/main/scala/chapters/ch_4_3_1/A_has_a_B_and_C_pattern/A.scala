package chapters.ch_4_3_1.A_has_a_B_and_C_pattern

import chapters.ch_4_3_1._

/*
If A has a b (with type B) and a c (with type C) - product type
*/

// Option 1 - case class
case class A(b: B, c: C)

// Option 2 - trait
trait AA {
  def b: B
  def c: C
}