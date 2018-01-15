package chapters.ch_4_6

sealed trait IntList

final case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

object workout extends App {
  Pair(1, Pair(2, Pair(3, End)))

  // d represents an empty sequence
  val d = End

  // c represents the sequence 3 (only one element)
  val c = Pair(3, d)

  // b represents the sequence 2, 3
  val b = Pair(2, c)

  // a represents the sequence 1, 2, 3
  val a = Pair(1, b)

  def sum(list: IntList): Int = {
    list match {
      case End => 0
      case Pair(hd, tl) => hd + sum(tl)
    }
  }

  val example = Pair(1, Pair(2, Pair(3, End)))

  private val sumExample = sum(example)
  println(s"Sum of $example = $sumExample")

  assert(sumExample  == 6)

  private val sumExamplesTail = sum(example.tail)
  println(s"Sum of ${example.tail} = $sumExamplesTail")

  assert(sumExamplesTail == 5)

  private val sumEnd = sum(End)
  println(s"Sum of $End = $sumEnd")

  assert(sumEnd == 0)
}