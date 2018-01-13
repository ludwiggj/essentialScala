package chapters.ch_5_5_1_2

/*
If A is a B or C, and we want to write a method f returning an F, define f as an abstract method on A and provide
concrete implementations in B and C.
 */

class F

sealed trait SumTypePolymorphismPattern {
  def f: F
}

final case class B() extends SumTypePolymorphismPattern {
  def f: F = ???
}

final case class C() extends SumTypePolymorphismPattern {
  def f: F = ???
}