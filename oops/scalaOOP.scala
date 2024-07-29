// Define Class

class Car (val make:String, var model:String, var year:Int){
  def displayInfo(): Unit = {
    println(s"CAR INFO :\n$year $make $model")
  }
}

// create object for class
object SimpleClass extends App {
  var car = new Car("Toyota","Corolla",2019)
  // car method using car object 
  car.displayInfo()
  
  
  //modify value of class 
  car.year = 2020
  car.model = "Fortuner"
  car.displayInfo()
}