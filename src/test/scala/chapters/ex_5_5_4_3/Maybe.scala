package chapters.ex_5_5_4_3

sealed trait Maybe[A] {
  def fold[B](empty: B, full: A => B): B = {
    this match {
      case Empty() => empty
      case Full(value) => full(value)
    }
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    this match {
      case Empty() => Empty[B]()
      case Full(value) => f(value)
    }
  }

  def map[B](f: A => B): Maybe[B] = {
    this.flatMap(z => Full(f(z)))
  }
}

final case class Full[A](value: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]

object MaybeWorkout extends App {
  val list = List(Full(3), Full(2), Full(1))

  // return a List[Maybe[Int]] containing None for the odd elements. Hint: If x % 2 == 0 then x is even.

  val evenList = list.map { x => if (x.value % 2 == 0) x else Empty() }
  println(evenList)

  val evenList2 = list.map(maybe => maybe flatMap { x => (if(x % 2 == 0) Full(x) else Empty()).asInstanceOf[Maybe[Int]] })
  println(evenList2)
}