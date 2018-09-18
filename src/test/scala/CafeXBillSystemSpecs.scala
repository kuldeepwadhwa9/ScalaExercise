import org.scalatest._

class CafeXBillSystemSpecs extends FlatSpec with Matchers{
  markup {
    """
      |#CafeXBillSystem
      |
      |##`calculateTotalCost`
      |This function takes list of purchased items and produces a total bill
      |
      |###`calculateTotalCostWithServiceCharge`
      |This function takes list of purchased items and products a total bill after applying service charge
    """.stripMargin
  }

  behavior of "CafeXBillSystem"

  it should "return total bill of no item bought as 0.00" in {
    CafeXBillSystem.calculateTotalCost(Nil) should be(0.00)
  }

  it should "return total bill of single item 'Cola' as 0.50" in {
    val item = Seq("Cola")
    CafeXBillSystem.calculateTotalCost(item) should be(0.50)
  }

  it should "return total bill of 2 items 'Cola, Cheese Sandwich' as 2.50" in {
    val items = Seq("Cola", "Cheese Sandwich")
    CafeXBillSystem.calculateTotalCost(items) should be(2.50)
  }

  it should "return total bill of 3 items 'Cola, Cheese Sandwich and Steak Sandwich' as 7.00" in {
    val items = Seq("Cola", "Cheese Sandwich", "Steak Sandwich")
    CafeXBillSystem.calculateTotalCost(items) should be(7.00)
  }

  it should "return the total bill of all the items as 8.00" in {
    val items = Seq("Cola", "Coffee", "Cheese Sandwich", "Steak Sandwich")
    CafeXBillSystem.calculateTotalCost(items) should be(8.00)
  }

  it should "return the total of items '2 Coffee, 2 Cheese Sandwich and 4 Steak Sandwich' as 24.00" in {
    val items = Seq("Coffee", "Coffee", "Cheese Sandwich", "Cheese Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich", "Steak Sandwich")
    CafeXBillSystem.calculateTotalCost(items) should be(24.00)
  }
}