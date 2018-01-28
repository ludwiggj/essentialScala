Tuple2("hi", 2)
("hi", 1.0)
("yo", 1, true)

def tuplized[A, B](in: (A, B)) = in._1

tuplized(("a", 1.0))

(1, "a") match {
  case (a, b) => a + b
}

val x = (1, "b", true)

x._1
x._2
x._3