import scala.io.StdIn
object employeeData{
  def main(args: Array[String]): Unit = {

    val employee = List(("Amal",35000),("Rohit",32000),("Adarsh",10000),("Prakash",20000),("Suresh",15000))
    val total_sum = employee.map(_._2).sum
    val (high_salary, low_salary) = employee.partition(_._2>(total_sum*0.1))
    println("*"*60)
    println("Total Salary : "+total_sum)
    println("10% of total salary :"+(total_sum*0.1))
    println("High Salary : "+high_salary.mkString(" "))
    println("Low Salary : " + low_salary.mkString(" "))
  }
}