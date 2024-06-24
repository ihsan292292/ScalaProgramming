object controlStatement{
  def main(args: Array[String]): Unit = {
    // Example1 if-else

    import scala.io.StdIn
    //    println("Enter a number")
    //    val x1 = StdIn.readInt() // readLine().toInt
    //
    //      if (x1>0){
    //      println("Value is positive")
    //    }
    //    else if(x1<0) {
    //      println("Value is negative")
    //    }
    //    else{
    //      println("Value is Zero")
    //    }
    // using if-else as an expression
    //    val x2 = StdIn.readInt()
    //    val output = if (x2%2==0) "even" else "odd"
    //    println(output)

    // While Loop
    var i = 1
    while (i <= 5) {
      println(s"Value of i is : $i")
      i += 1
    }

    // for loop
    val list_1 = List("Kerala", "UST1001", 22, "CSE", 78.76)

    for (value <- list_1) {
      println(value)
    }

    // generate a collection of even numbers
    //    val number = (1 to 50).toList
    //    val even = for {
    //            num <- number
    //            if num % 2 == 0
    //          } yield num // yield is used to generate new collection from an existing on

    // generate collection of prime number

    val prime = for {
      num <- 2 to 100
      if (2 until num).forall(x => num % x != 0)
    } yield num
    println(prime)
    
    
    // Task 1. Processing and Filtering Data
    // sample_record = (product_name,unit_price,discount, quantity)
    // 1. Filter out products that have price greater than $50
    // 2. Calculate total cost of each product
    // 3. Print the name of product that exceeded total cost 40000
    //

    val products = List(("samsungsS23",40000,1000,2),("iphone15",80000,1000,1),("lenovo",20000,1000,4))
//    //
//    var isGreater = false
//    for (p <- products) {
//     if p._2>40000
//    }yield p
    }
  }
