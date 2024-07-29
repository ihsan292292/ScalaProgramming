object loopsFunctions{
  def main(args: Array[String]): Unit = {
    //do-while loop
//    var i = 1
//    while (i <= 5){}
//    do {
//      println(i)
//      i += 1
//    }

    //for loop
    for (i<-1 to 10 by 2){
      println(i)
    }

    //iterationg over collection
    val fruits = List("apples","oranges","grapes","tomatos")
    for(fruit <- fruits){
      println(fruit)
    }

    //complex conditions
//    import scala.io.StdIn
//    print("Enter Temperature ")
//    val temparature = StdIn.readInt()
//    print("Enter Humiditty ")
//    val humidity = StdIn.readInt()
//
//    val wheatherDesc = if(temparature>30 & humidity>60){
//      "Hot and Humid"
//    }else if(temparature>40 & humidity<60){
//      "Hot"
//    }else if(humidity>60){
//    "Humid"
//    }else{
//      "pleasent"
//    }
//    print(wheatherDesc)

    //Functions in scala programming
    def add(a:Int, b:Int): Int = {
      a+b
    }

    //Anonymous functions like lambda
    val sum = (a:Int, b:Int)=> a+b
    println(sum(6,4))

    // create a function to find the maximum element in a list
    def findMax(lst:List[Int]): Int ={
      lst.max
    }
    val numbers = List(1,2,3,4,5,6)
    println(findMax(numbers))

    // Factorial
    val f = 1
    def fact(a:Int): Int={
      if (a == 0) 1
      else a*fact(a-1)
    }
    println(fact(5))
    
    //

  }
}