package chapters.ex_5_6_3

import scala.annotation.tailrec

/*

A binary tree of integers can be defined as follows:
A Tree is a Node with a left and right Tree or a Leaf with an element of type Int.
Implement this algebraic data type.
Implement sum and double on Tree using polymorphism and pattern matching.

 */

sealed trait BinaryTree[Int] {
  def sum: Int
  def double: BinaryTree[Int]
}

final case class Node(left: BinaryTree[Int], right: BinaryTree[Int]) extends BinaryTree[Int] {
  def sum: Int = left.sum + right.sum
  def double: BinaryTree[Int] = Node(left.double, right.double)
}

final case class Leaf(element: Int) extends BinaryTree[Int] {
  def sum: Int = element
  def double: BinaryTree[Int] = Leaf(2 * element)
}

object planting extends App {

  // Sum via pattern matching
  def sum(tree: BinaryTree[Int]): Int = {
    tree match {
      case Leaf(elem) => elem
      case Node(left, right) => sum(left) + sum(right)
    }
  }

  def sumTailRec(t: BinaryTree[Int]): Int = {
    @tailrec
    def sumAcc(trees: List[BinaryTree[Int]], acc: Int): Int = trees match {
      case Nil => acc
      case Leaf(x) :: rs => sumAcc(rs, x + acc)
      case Node(l, r) :: rs => sumAcc(l :: r :: rs, acc)
    }
    sumAcc(List(t), 0)
  }

  val tree = Node(Node(Node(Leaf(7), Leaf(6)), Leaf(23)), Leaf(14))
  assert(sum(tree) == 50)
  assert(sumTailRec(tree) == 50)
  assert(tree.sum == 50)

  // Don't think this would be easy to convert to tailrec
  def double(tree: BinaryTree[Int]): BinaryTree[Int] = {
    tree match {
      case Leaf(elem) => Leaf(2 * elem)
      case Node(left, right) => Node(double(left), double(right))
    }
  }

  assert(double(tree) == Node(Node(Node(Leaf(14), Leaf(12)), Leaf(46)), Leaf(28)))
  assert(tree.double == Node(Node(Node(Leaf(14), Leaf(12)), Leaf(46)), Leaf(28)))
}