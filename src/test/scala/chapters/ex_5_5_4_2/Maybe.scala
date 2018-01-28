package chapters.ex_5_5_4_2

sealed trait Maybe[A] {
  def fold[B](empty: B, full: A => B): B = {
    this match {
      case Empty() => empty
      case Full(value) => full(value)
    }
  }

  def map[B](f: A => B): Maybe[B] = {
    this match {
      case Empty() => Empty[B]()
      case Full(value) => Full(f(value))
    }
  }

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = {
    this match {
      case Empty() => Empty[B]()
      case Full(value) => f(value)
    }
  }

//  def map2[B](f: A => B): Maybe[B] = {
//    def g(x: A): Maybe[B] = {
//      Full(f(x))
//    }
//
//    this.flatMap(g)
//  }

  def map2[B](f: A => B): Maybe[B] = {
    this.flatMap(z => Full(f(z)))
  }
}

final case class Full[A](value: A) extends Maybe[A]

final case class Empty[A]() extends Maybe[A]

object MaybeWorkout extends App {
  val perhapsEmpty: Maybe[Int] = Empty[Int]
  val perhapsFull: Maybe[Int] = Full(1)

  println(perhapsEmpty.fold[Int](-1, _ * 2))
  println(perhapsFull.fold[Int](-1, _ * 2))

  println(perhapsEmpty.map(_ * 5))
  println(perhapsFull.map(_ * 5))

  println(perhapsEmpty.flatMap(x => Full(x.toString + " 5")))
  println(perhapsFull.flatMap(x => Full(x.toString + " 5")))

  println(perhapsEmpty.map2(_ * 5))
  println(perhapsFull.map2(_ * 5))
}