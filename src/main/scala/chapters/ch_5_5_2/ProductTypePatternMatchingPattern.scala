package chapters.ch_5_5_2

/*
    A has a b (with type B) and a c (with type C), and we want to write a method f that accepts an A and returns an F
 */

class B
class C
class F

case class A(b: B, c: C)

object example {
  def f(a: A): F =
    a match {
      // In the body of the method we use b and c to construct the result of type F.
      case A(b, c) => ???
    }
}