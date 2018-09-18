import org.scalatest._

class CafeXBillSystemSpecs extends FlatSpec with Matchers {
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

  it should "return the total bill of items 'Cola, Coffee - apply no service charge when all purchased items are drink' as 1.50" in {
    val items = Seq("Cola", "Coffee")
    CafeXBillSystem.calculateTotalCostWithServiceCharge(items) should be(1.50)
  }

  it should "return total bill of items 'Cola, Coffee, Cheese Sandwich - if bill includes food item apply service charge of 10%' as 3.85" in {
    val item = Seq("Cola", "Coffee", "Cheese Sandwich")
    CafeXBillSystem.calculateTotalCostWithServiceCharge(item) should be(3.85)
  }

  it should "return total bill of items 'Coffee and Steak Sandwich - if bill includes any hot food item apply service charge of 20%' as 6.60" in {
    val items = Seq("Coffee", "Steak Sandwich")
    CafeXBillSystem.calculateTotalCostWithServiceCharge(items) should be(6.60)
  }

  it should "return total bill of multiple items 'drinks and Cheese Sandwich - if bill includes food item apply service charge of 10%' as 5.50" in {
    val items = Seq("Cola", "Cola", "Coffee", "Coffee", "Cheese Sandwich")
    CafeXBillSystem.calculateTotalCostWithServiceCharge(items) should be(5.50)
  }

  it should "return total bill of '30 Steak Sandwiches - apply 20% service charge on hot food purchased with max £20 of service charge' as 155.00" in {
    val items = Seq.fill(30)("Steak Sandwich")
    CafeXBillSystem.calculateTotalCostWithServiceCharge(items) should be(155.00)
  }
}