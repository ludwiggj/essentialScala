package chapters.ex_5_3_4

sealed trait Tree[A] {
  def fold[B](leaf: A => B, node: (B, B) => B): B =
    this match {
      case Leaf(elem) => leaf(elem)
      case Node(left, right) => node(left.fold(leaf, node), right.fold(leaf, node))
    }
}

final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]

final case class Leaf[A](elem: A) extends Tree[A]

object TreeToString extends App {
  val tree: Tree[String] =
    Node(Node(Leaf("To"), Leaf("iterate")),
      Node(Node(Leaf("is"), Leaf("human,")),
        Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

  println(tree.fold[String](x => x, _ + " " +  _))
}