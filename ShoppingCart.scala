import scala.collection.mutable.ListBuffer
import scala.io.StdIn._

// Item Class
case class Item(id: Int, name: String, quantity: Int, price: Double, category: String)

// ShoppingCart Class
class ShoppingCart {
  private val items = ListBuffer[Item]()
  private val gstRate = 0.05
  private val deliveryChargeThreshold = 200.0
  private val deliveryCharge = 30.0

  def addItem(item: Item): Unit = {
    items += item
    println("Item added successfully!")
  }

  def updateItem(id: Int, updatedItem: Item): Unit = {
    val index = items.indexWhere(_.id == id)
    if (index != -1) {
      items(index) = updatedItem
      println("Item updated successfully!")
    } else {
      println(s"Item with id $id not found.")
    }
  }

  def removeItem(id: Int): Unit = {
    val index = items.indexWhere(_.id == id)
    if (index != -1) {
      items.remove(index)
      println("Item removed successfully!")
    } else {
      println(s"Item with id $id not found.")
    }
  }

  def viewCart(): Unit = {
    if (items.isEmpty) {
      println("The cart is empty.")
    } else {
      println("Viewing cart:")
      items.zipWithIndex.foreach { case (item, index) =>
        println(s"${index + 1}. [${item.id}] ${item.name} - Quantity: ${item.quantity}, Price: ${item.price}, Category: ${item.category}")
      }
    }
  }

  def totalPrice(withGST: Boolean = true): Double = {
    val total = items.map(item => item.quantity * item.price).sum
    val gst = if (withGST) total * 0.05 else 0.0
    val finalTotal = if (total < 200.0) total + gst + 30.0 else total + gst
    println(f"Cart Value:\t\t₹$total%.2f")
    if (total < 200.0) println(s"Delivery Charge:\t₹30.0")
    println(f"GST:\t\t\t₹$gst%.2f")
    println(f"Amount Payable:\t\t₹$finalTotal%.2f")
    finalTotal
  }
}

// PaymentGateway Class
class PaymentGateway {
  def processPayment(amount: Double, paymentMethod: String): String = {
    paymentMethod match {
      case "Credit Card" | "Debit Card" | "UPI" =>
        s"Processing payment of ₹$amount using $paymentMethod...\nPayment successful! Confirmation number: UST123456789"
      case _ =>
        "Invalid payment method. Please choose Credit Card, Debit Card, or UPI."
    }
  }
}

// Main Application
object ShoppingCartApp extends App {
  val cart = new ShoppingCart()
  val paymentGateway = new PaymentGateway()
  var itemIdCounter = 1

  def addItem(): Unit = {
    println("Enter item name:")
    val name = readLine()
    println("Enter quantity:")
    val quantity = readInt()
    println("Enter price:")
    val price = readDouble()
    println("Enter category:")
    val category = readLine()
    val item = Item(itemIdCounter, name, quantity, price, category)
    cart.addItem(item)
    itemIdCounter += 1
  }

  def updateItem(): Unit = {
    println("Enter item id to update:")
    val id = readInt()
    println("Enter new item name:")
    val name = readLine()
    println("Enter new quantity:")
    val quantity = readInt()
    println("Enter new price:")
    val price = readDouble()
    println("Enter new category:")
    val category = readLine()
    val updatedItem = Item(id, name, quantity, price, category)
    cart.updateItem(id, updatedItem)
  }

  def removeItem(): Unit = {
    println("Enter item id to remove:")
    val id = readInt()
    cart.removeItem(id)
  }

  def viewCart(): Unit = {
    cart.viewCart()
  }

  def calculateTotal(): Unit = {
    println("Include GST in total price? (yes/no)")
    val includeGST = readLine().toLowerCase() == "yes"
    cart.totalPrice(includeGST)
  }

  def makePayment(): Unit = {
    val amount = cart.totalPrice()
    println("Choose a payment method (Credit Card/Debit Card/UPI):")
    val paymentMethod = readLine()
    val confirmation = paymentGateway.processPayment(amount, paymentMethod)
    println(confirmation)
  }

  def mainMenu(): Unit = {
    var exit = false
    while (!exit) {
      println(
        """
          |***** Welcome to the UST Shopping Cart *****
          |
          |Please choose an option:
          |1. Add a new item
          |2. Update an existing item
          |3. Remove an item
          |4. View cart
          |5. Calculate total price
          |6. Make payment
          |7. Exit
          |
          |Option: 
        """.stripMargin)
      val choice = readInt()
      choice match {
        case 1 => addItem()
        case 2 => updateItem()
        case 3 => removeItem()
        case 4 => viewCart()
        case 5 => calculateTotal()
        case 6 => makePayment()
        case 7 =>
          println("Exiting the application. Goodbye!")
          exit = true
        case _ => println("Invalid choice. Please try again.")
      }
    }
  }

  mainMenu()
}
