package chapters.ex_5_1_3_1

sealed trait LinkedList[A]

// final case object End extends LinkedList[Nothing]

final case class End[A]() extends LinkedList[A]

final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]