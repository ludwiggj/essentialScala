package chapters.ch_4_3_1.is_a_or_pattern

/*
If A is a B or C (sum type)
 */

sealed trait A

final case class B() extends A

final case class C() extends A