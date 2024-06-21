object controlStatement{
  def main(args: Array[String]): Unit = {
    // Example1 if-else
    val x1 = 10
    if (x1>0){
      println("Value is positive")
    }
    else if(x1<0) {
      println("Value is negative")
    }
    else{
      println("Value is Zero")
    }
  }
}