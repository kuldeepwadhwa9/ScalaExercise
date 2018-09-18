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

  def calculateTotalCostWithServiceCharge(items: Seq[String]): BigDecimal = {
    val totalCost = calculateTotalCost(items)
    val totalCostWithServiceCharge = {
      if (items.contains("Steak Sandwich")) {
        val serviceCharge = totalCost * 20 / 100
        if (serviceCharge > 20)
          totalCost + 20
        else totalCost + serviceCharge
      }
      else if (items.contains("Steak Sandwich") || items.contains("Cheese Sandwich")) totalCost + (totalCost * 10 / 100)
      else totalCost
    }
    totalCostWithServiceCharge
  }
}

object CafeXBillSystem extends CafeXBillSystem
