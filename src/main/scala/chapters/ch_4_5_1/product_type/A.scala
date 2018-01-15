package chapters.ch_4_5_1.product_type

import chapters.ch_4_5_1._

case class B()

case class C()

case class A(b: B, c: C) {
  // If A has a b (with type B) and a c (with type C), and we want to write a method f returning an F, simply
  // write the method in the usual way.

  // In the body of the method we must use b, c, and any method parameters to construct the result of type F.
  def f: F = ???
}

object Workout extends App {

  A(B(), C())

  // Pattern matching on product type

  // If A has a b (with type B) and a c (with type C), and we want to write a method f that accepts an A and
  // returns an F, write:

  def f(a: A): F =
    a match {
      // In the body of the method we use b and c to construct the result of type F
      case A(b, c) => ???
    }
}