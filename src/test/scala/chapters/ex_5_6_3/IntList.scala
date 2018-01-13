package chapters.ex_5_6_3

import scala.annotation.tailrec


sealed trait IntList {

  /*
  Using our definition of IntList define a method length that returns the length of the list. There is test data below you
  can use to check your solution. For this exercise it is best to use pattern matching in the base trait.
   */
  def length() = {
    @tailrec
    def length(l: IntList, acc: Int = 0): Int = {
      l match {
        case End => acc
        case Pair(head, tail) => length(tail, acc + 1)
      }
    }

    length(this)
  }

  // Define a method to compute the product of the elements in an IntList.
  def product() = {
    @tailrec
    def product(l: IntList, prod: Int = 1): Int = {
      l match {
        case End => prod
        case Pair(head, tail) => product(tail, prod * head)
      }
    }

    product(this)
  }

  // Define a method to double the value of each element in an IntList, returning a new IntList.

  /*

    Note: Inner method double(l: IntList, doubledList: IntList = End) naturally reverses the list,
    hence the need to reverse it first:

    Example call trace to demonstrate:

    val example = Pair(1, Pair(2, Pair(3, End)))

    double(example)

    => double(Pair(1, Pair(2, Pair(3, End))), End)
    => double(Pair(2, Pair(3, End)), Pair(2, End))
    => double(Pair(3, End)), Pair(4, Pair(2, End))
    => double(End, Pair(6, Pair(4, Pair(2, End))))
  */
  def double() = {
    @tailrec
    def double(l: IntList, doubledList: IntList = End): IntList = {
      l match {
        case End => doubledList
        case Pair(head, tail) => double(tail, Pair(head * 2, doubledList))
      }
    }

    @tailrec
    def reverse(l: IntList, reversedList: IntList = End): IntList = {
      l match {
        case End => reversedList
        case Pair(head, tail) => reverse(tail, Pair(head, reversedList))
      }
    }

    double(reverse(this))
  }
}

final case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

object workIt extends App {
  val example = Pair(1, Pair(2, Pair(3, End)))

  private val exampleLength = example.length
  println(s"$example length = $exampleLength")
  assert(exampleLength == 3)

  private val exampleTailLength = example.tail.length
  println(s"${example.tail} length = $exampleTailLength")
  assert(exampleTailLength == 2)

  private val endLength = End.length
  println(s"$End length = $endLength")
  assert(endLength == 0)

  private val exampleProduct = example.product
  println(s"$example product = $exampleProduct")
  assert(exampleProduct == 6)

  private val exampleTailProduct = example.tail.product
  println(s"${example.tail} product = $exampleTailProduct")
  assert(exampleTailProduct == 6)

  private val endProduct = End.product
  println(s"$End product = $endProduct")
  assert(endProduct == 1)

  private val exampleDouble = example.double
  println(s"$example double = $exampleDouble")
  assert(example.double == Pair(2, Pair(4, Pair(6, End))))

  private val exampleTailDouble = example.tail.double
  println(s"${example.tail} double = $exampleTailDouble")
  assert(exampleTailDouble == Pair(4, Pair(6, End)))

  private val endDouble = End.double
  println(s"$End double = $endDouble")
  assert(endDouble == End)
}