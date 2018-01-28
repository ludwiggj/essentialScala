final case class Box[A](value: A)

val a = Box(2)

a.value

val b = Box("yo")

b.value

def generic[A](in: A): A = in

generic[String]("foo")

generic(1)