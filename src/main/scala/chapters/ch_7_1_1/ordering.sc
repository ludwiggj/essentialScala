val minOrdering = Ordering.fromLessThan[Int](_ < _)
val maxOrdering = Ordering.fromLessThan[Int](_ > _)

List(3, 4, 2).sorted(minOrdering)
List(3, 4, 2).sorted(maxOrdering)