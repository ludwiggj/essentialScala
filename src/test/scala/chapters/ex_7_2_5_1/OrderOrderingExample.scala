package chapters.ex_7_2_5_1

final case class Order(units: Int, unitPrice: Double) {
  val totalPrice: Double = units * unitPrice
}

object OrderByTotalPriceIncreasing {
  implicit val ordering = Ordering.fromLessThan[Order](
    _.totalPrice < _.totalPrice
  )
}

object OrderByTotalPriceDecreasing {
  implicit val ordering = Ordering.fromLessThan[Order](
    _.totalPrice > _.totalPrice
  )
}

object OrderByUnitsIncreasing {
  implicit val ordering = Ordering.fromLessThan[Order](
    _.units < _.units
  )
}

object OrderByUnitsDecreasing {
  implicit val ordering = Ordering.fromLessThan[Order](
    _.units > _.units
  )
}

object OrderByUnitPriceIncreasing {
  implicit val ordering = Ordering.fromLessThan[Order](
    _.unitPrice < _.unitPrice
  )
}

object OrderByUnitPriceDereasing {
  implicit val ordering = Ordering.fromLessThan[Order](
    _.unitPrice > _.unitPrice
  )
}

object OrderOrderingExample {
  def main(args: Array[String]): Unit = {

    val orders = List(Order(2, 2.5), Order(10, 0.3), Order(28, 1.2), Order(60, 0.5), Order(12, 0.9))

    def byTotalPriceIncreasing = {
      import OrderByTotalPriceIncreasing.ordering

      assert(orders.sorted ==
        List(Order(10, 0.3), Order(2, 2.5), Order(12, 0.9), Order(60, 0.5), Order(28, 1.2)))
    }

    def byTotalPriceDereasing = {
      import OrderByTotalPriceDecreasing.ordering

      assert(orders.sorted ==
        List(Order(28, 1.2), Order(60, 0.5), Order(12, 0.9), Order(2, 2.5), Order(10, 0.3)))
    }

    def byUnitsIncreasing = {
      import OrderByUnitsIncreasing.ordering

      assert(orders.sorted ==
        List(Order(2, 2.5), Order(10, 0.3), Order(12, 0.9), Order(28, 1.2), Order(60, 0.5)))
    }

    def byUnitsDecreasing = {
      import OrderByUnitsDecreasing.ordering

      assert(orders.sorted ==
        List(Order(60, 0.5), Order(28, 1.2), Order(12, 0.9), Order(10, 0.3) , Order(2, 2.5)))
    }

    def byUnitsPriceIncreasing = {
      import OrderByUnitPriceIncreasing.ordering

      assert(orders.sorted ==
        List(Order(10, 0.3), Order(60, 0.5), Order(12, 0.9), Order(28, 1.2), Order(2, 2.5)))
    }

    def byUnitsPriceDecreasing = {
      import OrderByUnitPriceDereasing.ordering

      assert(orders.sorted ==
        List(Order(2, 2.5), Order(28, 1.2), Order(12, 0.9), Order(60, 0.5), Order(10, 0.3)))
    }

    byTotalPriceIncreasing
    byTotalPriceDereasing
    byUnitsIncreasing
    byUnitsDecreasing
    byUnitsPriceIncreasing
    byUnitsPriceDecreasing
  }
}