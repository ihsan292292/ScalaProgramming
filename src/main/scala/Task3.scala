object Task3{
  def main(args:Array[String]): Unit = {
    //Create a banking menu
//    1. Check Balance
//    2.Withdraw aamount
//    3. Deposit Amount
//    4.Exit
      import io.StdIn

      var continue = true
      var balance: Float = 25000
      while(continue) {
        println("*"*100)
        println("1.Check Balance\n2.Withdraw Amount\n3.Deposit\n4.Exit")
        println("Enter Number to continue : ")
        val in = StdIn.readInt()
        if (in == 1) {
          println("Balance is : " + balance)
        } else if (in == 2) {
          println("How much you want to withdraw : ")
          val withdraw: Int = StdIn.readInt()

          if(withdraw<0){
            print("Enter positive!!")
          }else{
            if(withdraw<=balance){
              balance = balance-withdraw
          }else{
              println("Insufficient balance!!")
            }
          }
          println("Current Balance is :" + balance)
        } else if (in==3){
          println("How much you want to deposit : ")
          val deposit: Int = StdIn.readInt()
          if(deposit>0){
            balance = balance + deposit
          }else{
            println("enter positive amount!!")
          }
          println("Current Balance is :"+balance)
        }else if (in==4){
          println("Thank You !!")
          continue = false
        }
        else{
          println("Enter Valid Number!!")
        }
      }



  }
}