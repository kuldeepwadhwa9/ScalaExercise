class CafeXBillSystem {

  val costOfSingleColaCold = 0.50
  val costOfSingleCoffeeHot = 1.00
  val costOfSingleCheeseSandwichCold = 2.00
  val costOfSingleSteakSandwichHot = 4.50

  def calculateTotalCost(items: Seq[String]): BigDecimal = {
    val costOfCola = totalCostOfItems(items.filter(_ == "Cola"), costOfSingleColaCold)
    val costOfCoffee = totalCostOfItems(items.filter(_ == "Coffee"), costOfSingleCoffeeHot)
    val costOfCheeseSandwich = totalCostOfItems(items.filter(_ == "Cheese Sandwich"), costOfSingleCheeseSandwichCold)
    val costOfSteakSandwich = totalCostOfItems(items.filter(_ == "Steak Sandwich"), costOfSingleSteakSandwichHot)

    val totalCost = costOfCola + costOfCoffee + costOfCheeseSandwich + costOfSteakSandwich
    totalCost
  }

  private[this] def totalCostOfItems(items: Seq[String], costOfSingleItem: BigDecimal): BigDecimal = {
    items.map(_ => costOfSingleItem).sum
  }
}

object CafeXBillSystem extends CafeXBillSystem
