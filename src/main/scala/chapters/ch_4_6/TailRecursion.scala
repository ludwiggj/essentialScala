package chapters.ch_4_6

import scala.annotation.tailrec

object tailRecExample {

/*
  @tailrec
  def sum(list: IntList): Int =
    list match {
      case End => 0
        // Compilation error - could not optimize @tailrec annotated method sum: it contains a recursive call not in
        // tail position
        list match {
          case End => 0
          case Pair(hd, tl) => hd + sum(tl)
        }
    }
*/

  @tailrec
  def sum(list: IntList, total: Int = 0): Int =
    list match {
      case End => total
      case Pair(hd, tl) => sum(tl, total + hd)
    }
}