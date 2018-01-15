package chapters.ch_4_3_1.A_has_a_B_or_C_pattern

/*
   The “has-a or” patterns means that A has a B or C. There are two ways we can implement this.
*/

/*
   Option 1

   We can say that A has a d of type D, where D is a B or C. We can mechanically apply our two patterns to implement
   this:
*/

trait A {
  def d: D
}

sealed trait D

final case class B() extends D

final case class C() extends D

/*
   Option 2

   A is a D or E, and D has a B and E has a C. Again this translates directly into code
*/

sealed trait AA

final case class DD(b: B) extends AA

final case class EE(c: C) extends AA