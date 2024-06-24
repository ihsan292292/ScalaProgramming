object DataStructureMethods{
  def Main(args: Array[String]): Unit = {
    //List & its methods 
    val list1 = List("apple","orange","banana","watermelon")
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
    val list3 = List(1,2,3,4,5,6,7,8)
    val new_list = 0 :: list3
    val appendList = list3 :+ 9
  }
}