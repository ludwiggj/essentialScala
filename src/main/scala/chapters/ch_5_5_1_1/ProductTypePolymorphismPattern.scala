package chapters.ch_5_5_1_1

/*
If A has a b (with type B) and a c (with type C), and we want to write a method f returning an F, simply write the
method in the usual way. In the body of the method we must use b, c, and any method parameters to construct the result
of type F.
 */

class B
class C
class F

case class ProductTypePolymorphismPattern(b: B, c: C) {
  def f: F = ???
}