import scala.collection.mutable.ListBuffer

object dataStructures{
  def main(args: Array[String]): Unit = {
    // list : immutable collection of (homogeneous) of Data
    var animals: List[String] = List("cat", "dog", "elephant")
    println("First Element : " + animals.head)
    println("Value Excluding First Element : " + animals.tail)
    println("Last Element : " + animals.last)

    var fruits = List("apple", "banana", "orange", 400, false)
    println(fruits.getClass)

    val emptyList: List[Nothing] = List()

    //Array
    var arrayVal = Array("apple", "banana", "orange", 400, false)
    arrayVal.foreach(println)

    println(arrayVal.mkString(","))
    arrayVal(0) = "Watermelon"
    println(arrayVal.mkString(","))

    //declare
    val arr1 = new Array[String](5)
    val arr2 = Array.ofDim[Int](2, 2)
    arr2(0)(0) = 123
    arr2(0)(1) = 456
    arr2(1)(0) = 789
    arr2(1)(1) = 321

    //print array
    val flattenArray: Array[Int] = arr2.flatten
    flattenArray.foreach(println)

    //list declaration
    val list2 = 10 :: 20 :: 30 :: 40 :: Nil
    list2.foreach(println)

    import scala.collection.mutable.ListBuffer
    var cities = new ListBuffer[String]()
    cities += "Mlappuram"
    cities += ("Mlappuram", "Kozhikkode", "Trivandrum")

    println(cities)
    cities.toList


    //set
    var set_1: Set[String] = Set()
    var set_2: Set[String] = Set("Mlappuram", "Kozhikkode", "Trivandrum")

    import scala.collection.mutable.Set
    val mutableSet = Set("Mlappuram", "Kozhikkode", "Trivandrum")
    mutableSet += "pandikkad"
    mutableSet -= "Apple"

    //Tuple
    //Tuple is immutable
    val tuple1 = (1, 2, "Ath Thanne", 4, 5, 6, 7)
    //Tuple_1._1 = 10, update will fails
    println(tuple1._3)

    //Map
    //collection of key value pair
    //each key is

    //import scala.collection.immutable.Map
    import scala.collection.mutable.Map
    //empty variable declaration
    var MapVar:Map[String,Int] = Map()
    var MapVar1 = Map("281764" -> "Ihsan K", "213454" -> "Midhun","213243" -> "Adnan" )
    println(MapVar1.contains("281764"))
    println(MapVar1.get("281764"))
    println(MapVar1.keys)
    println(MapVar1.values)
    MapVar1("281764") = "Ihsan Kadayi"
    println(MapVar1.values)


    //Iterators in Scala Programming
    //Iterator in scala represent a sequential of elements that allows you traverse
    //through a collection sequence
    val mylist = List(20,30,40,50,60,70,80,90)
    val iter = mylist.iterator
    //method of iterator is basically used to check if there is more elements
    // (.hasNext()), .next() - to retrieve value
    // .remove() - remove elements from mutable iterator
    println(iter.next())
    println(iter.next())

    //
    // 4) LAZY INITIALISATION (must be val)
    lazy val donuts: Int = 100
    println(donuts * 5)

  }
}