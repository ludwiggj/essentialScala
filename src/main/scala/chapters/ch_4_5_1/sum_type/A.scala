package chapters.ch_4_5_1.sum_type

import chapters.ch_4_5_1.F

// If A is a B or C, and we want to write a method f returning an F, define f as an abstract method on A and
// provide concrete implementations in B and C.

sealed trait A {
  def f: F
}

final case class B() extends A {
  def f: F = ???
}

final case class C() extends A {
  def f: F = ???
}

object Workout extends App {

  // Pattern matching

  // If A is a B or C, and we want to write a method f accepting an A and returning an F, define a pattern
  // matching case for B and C.

  def f(a: A): F =
    a match {
      case B() => ???
      case C() => ???
    }
}