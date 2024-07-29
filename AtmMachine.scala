import scala.io.StdIn
import scala.util.Random

object AtmMachine {
  def main(args: Array[String]): Unit = {
    println("#2000 notes : ")
    val x_2000 = StdIn.readInt() * 2000
    println("#500 notes : ")
    val x_500 = StdIn.readInt() * 500
    println("#100 notes : ")
    val x_100 = StdIn.readInt() * 100
    println("#50 notes : ")
    val x_50 = StdIn.readInt() * 50
    println("#10 notes : ")
    val x_10 = StdIn.readInt() * 10
    var total_balance = x_2000 + x_500 + x_100 + x_50 + x_10
    println("Total Balance : " + total_balance)

    println("How Much You Want To Withdraw : ")
    val amount = StdIn.readInt()

    if (amount > 0 && amount <= total_balance) {
      total_balance -= amount
      val notes = withdrawRandomNotes(amount)
      println(s"Withdraw $amount with the following notes distribution:")
      notes.foreach { case (note, count) => println(s"$note notes: $count") }
      println(s"New balance $total_balance")
    } else {
      println("Insufficient Funds or Invalid Amount!!")
    }
  }
  def withdrawRandomNotes(amount: Int): Map[Int, Int] = {
    val notes_available = List(2000, 500, 100, 50, 10)
    var remainingAmount = amount
    val random = new Random()
    var noteCount = Map[Int, Int]().withDefaultValue(0)

    while (remainingAmount > 0) {
      val note = notes_available(random.nextInt(notes_available.size))
      if (note <= remainingAmount) {
        noteCount += note -> (noteCount(note) + 1)
        remainingAmount -= note
      }
    }

    noteCount
  }
}
