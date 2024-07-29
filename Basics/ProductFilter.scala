object ProductFilter {


  def main(args: Array[String]): Unit = {


//    val products_list = List(("Butter", 60, 10, 15), ("Chocolate", 100, 20, 25),
//      ("Milk", 40, 0, 15), ("Biscuit", 40, 5, 30))
//
//    //1.Filter out products that have price greater than $50
//    val filtered_product = for {
//      (product_name, unit_price, discount, quantity) <- products_list
//      if unit_price >= 50
//    } yield (product_name, unit_price, discount, quantity)
//    println("Products having price greater than $50")
//    filtered_product.foreach(println)
//
//    //2.Calculate total cost of each product
//    val total_cost_products = for {
//      (product_name, unit_price, discount, quantity) <- products_list
//    } yield {
//      val total_cost = unit_price * quantity - discount
//      (product_name, total_cost)
//    }
//
//    //3.Print the name of product that has exceeded total cost greater than $600
//    println("Products having total cost greater than 600")
//    for {
//      (product_name, total_cost) <- total_cost_products
//      if total_cost > 600
//    } {
//      println(product_name)
//    }
val list1 = List("apple", "orange", "banana", "watermelon")
    //empty list
    val list2 = List()
    //Basic operations
    val first_element = list1.head
    val rest_of_list = list1.tail
    val second_element = list1(1)
    println(second_element)
    //is empty
    val is_list_empty = list1.isEmpty
    println(is_list_empty)

    //length
    val length = list1.length

    //adding and removing
    val list3 = List(1, 2, 3, 4, 5, 6, 7, 8)
    val new_list = 0 :: list3
    val appendList = list3 :+ 9
    println("List 3 : "+new_list)
    println("appendList : "+appendList)

    //concatinating between 2 list
    val concatList = list3 ::: List(10,11,12,13)
    val concatList2 = list3 ::: List(10,11,12,13)
    println("concatList : "+concatList)
    println("concatList2 : "+concatList2)

    //drop or removing (update the list)
    print(concatList.drop(1))

    //remove by value
    val updatedList = concatList.filter(_ != 3)
    val updatedList2 = concatList.diff(List(3,4,5))
    println("Updated Value : "+updatedList)
    println("Updated Value 2: "+updatedList2)

    //Transforming
    val mapList = updatedList.map(_ *2)
    println("updated list after Map : "+mapList)
    updatedList.filter(_ % 2 == 0)
    val nestedlist = List(List(1,2,3),List(4,5,6),List(7))
    val flatList = nestedlist.flatMap(identity)
    println(flatList)

    val sum = flatList.sum
    // using reduce
    val mulReduce = flatList.reduce(_*_)
    println("Sum : "+sum)
    println("Multiply using Reduce : "+mulReduce)

    //slicing & subset
    val first3 = list1.take(3)
    val last3 = list1.takeRight(3)
    println("First 3 : "+first3)
    println("Last 3 : "+last3)
    val dropList = list1.drop(3)
    println("After Drop : " + dropList)
    val dropList2 = list1.dropRight(3)
    println("After Drop 2: " + dropList2)

    //converting list to map
    val listofTuples = List(("UST1001","Krishna"),("UST002","Adinan"),("UST1003","Rohit"))
    val map = listofTuples.toMap
    println("After Mapping : "+map)

    //zipped list
    val zippedList = list1.zip(flatList)
    println("After Zipping : "+zippedList)

    val (fruits, numbers) = zippedList.unzip
    println("After Unzipping Fruits : "+fruits)


    // Set
    val set1 = Set(1,2,3,4,5,6,7,8)
    val set2 = Set("apple", "orange", "banana", "watermelon")

    //check
    println(set1.contains(3)) //Boolean

    //Adding and removing elements
    set1 + 9
    set1 - 2
    //set operations
    val SetA = Set(10,20,30,40)
    val SetB = Set(50,60,70,80)

    val unionSet = SetA union SetB
    SetA intersect SetB
    SetA diff SetB

    //subset check
    SetA.subsetOf(SetB)

    val sumSet = SetA.reduce(_+_)
    val mulSet = SetA.map(_ *2)
    val remSet = SetA.filter(_!=10)

    println("Sum of set items : "+sumSet)
    println("Multiply of set items : "+sumSet)
    println("Removing item in set : " + remSet)
    SetA.foreach(println)

    // import scala.io.collection.mutable
    println("*"*60)
    //Array
    val array1 = Array("Kochi","Varkala","Trivandrun","alappuzha")
    val array2 = Array(1,2,3,4,5,6,7,8)

    //empty array
    val emptyArray = Array[Int]()
    array2(0) = 10

    import scala.collection.mutable.ArrayBuffer
    // Adding Elements (Arrays are fixed size, so we use Array Buffer)

    val arrayBuffer = ArrayBuffer(1,2,3,4,5,6,7)
    arrayBuffer += 8
    arrayBuffer -= 5
    arrayBuffer.foreach(println)
    array2.foreach(println)

    arrayBuffer.map(_ *2)
    val array3 = arrayBuffer.toArray

    //Nested Array
    val nestedArray = Array(Array(1,2),Array(2,3,4),Array(9,8,7))
    val flattenArray = nestedArray.flatten

    //slicing array
    flattenArray.slice(1,5)
    val array4 = Array(30,40,50,10,20,60,70)
    println(array4.sorted.mkString(","))

    //group by
    val city = Array("Kochi","Varkala","Trivandrun","alappuzha","Malappuram")
    val groupByLen = city.groupBy(_.length)
    val groupByFirstChar = city.groupBy(_.charAt(0))
    val OddEven = flattenArray.groupBy(num=> if (num%2==0) "even" else "odd")
    groupByLen.foreach{
        case(key,value)=> println(s"$key:${value.mkString(", ")}")
        }
//    println("group byb first char :"+groupByFirstChar.mkString(","))

      val FirstVowel = city.groupBy { cityName =>
          if ("aeiou".contains(cityName.charAt(0).toLower)) "vowels :" else "consonant :"
      }
      FirstVowel.foreach{
          case(key,value)=> println(s"$key:${value.mkString(", ")}")
      }


      // Map
      val immutableMap = Map("a"->1,"b"->2,"c"->3)
      import scala.collection.mutable
      val mutableMap = mutable.Map("a"->1,"b"->2,"c"->3)

      println(immutableMap("a"))
      //concat 2 map
      val mapA = Map("a"->1,"b"->2,"c"->3)
      val mapB = Map("d"->4,"e"->5,"f"->6)

      val mergedMap = mapA++mapB

      println(mergedMap)

      // Transforming keys and values
      val incrementValue = immutableMap.mapValues(_+1)
      val transformkey = immutableMap.map{case(k,v)=>(k.toUpperCase,v)}
      println(transformkey)
      transformkey.foreach{
          case(key,value) => println(s"$key->$value")
      }
  }
}