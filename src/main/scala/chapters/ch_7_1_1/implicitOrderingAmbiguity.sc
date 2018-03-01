implicit val minOrdering = Ordering.fromLessThan[Int](_ < _)
implicit val maxOrdering = Ordering.fromLessThan[Int](_ > _)

List(3, 4, 1).sorted