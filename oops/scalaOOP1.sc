// Define Class

class Animal (val name:String){
  def makeSound(): Unit = {
    println(s"$name is making sound !!")
  }
}

// create object for class
class Dog (name:String) extends Animal(name) {
  override def makeSound(): Unit = {
    print(s"$name says woof")
  }

//
//  //modify value of class
//  car.year = 2020
//  car.model = "Fortuner"
//  car.displayInfo()
}
object InheritObj extends App{
  val animal = new Animal("Generic Name")
  animal.makeSound()
  val dog = new Dog("Charlie")
  dog.makeSound()
}