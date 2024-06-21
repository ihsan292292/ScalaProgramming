import java.util.function.DoubleUnaryOperator
// object is singleton instance that is lazily initialized

object dataTypes{
  // main is entry point to any scala application
  // unit define the return table
  def main(args: Array[String]): Unit = {

    // Integer Data type
    val intNum: Int = 20
    val longNum: Long = 1234567890L
    val shortNum: Short = 2341
    val byteNum: Byte = 127

    // Floating Datatypes
    val FloatingNum: Float = 3.14f
    val DoubleNum: Double = 3.4145945678

    // String Datatypes
    val StringVariable: String = "Hello Scala"

    // Character Datatype
    val charar: Char = 'A'

    // UnitDatatypes (void)
    val unitValue:Unit = ()

    // print values
    println(s"Integer : $intNum")
    // print(s"unit : $unitValue")
    println(s"short number : $shortNum")
    println(s"double number : $DoubleNum")
    println(s"long number : $longNum")

    //Mutable Data type
    // Boolean
    var boolVar: Boolean = true
    println("Boolean :" + boolVar)
    var intVar: Int = 1234
    println("Integer variable :"+intVar)
    intVar = 35
    println("Integer variable :" + intVar)

  }
}