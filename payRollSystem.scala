object PayrollSystem {
  sealed trait Employee
  case class FullTimeEmployee(name: String, annualSalary: Double) extends Employee
  case class PartTimeEmployee(name: String, hourlyWage: Double, hoursWorked: Double) extends Employee
  case class ContractEmployee(name: String, contractAmount: Double) extends Employee
  case class Freelancer(name: String, projectRate: Double, projectsCompleted: Int) extends Employee

  def calculateSalary(employee: Employee): Double = {
    employee match {
      case FullTimeEmployee(_, annualSalary) => annualSalary / 12
      case PartTimeEmployee(_, hourlyWage, hoursWorked) => hourlyWage * hoursWorked
      case ContractEmployee(_, contractAmount) => contractAmount
      case Freelancer(_, projectRate, projectsCompleted) => projectRate * projectsCompleted
    }
  }

  def main(args: Array[String]): Unit = {
    val employees = List(
      FullTimeEmployee("Abhijith", 60000),
      PartTimeEmployee("Ihsan", 20, 80),
      ContractEmployee("Rangan", 5000),
      Freelancer("Sandeep", 500, 3)
    )

    employees.foreach { employee =>
      val salary = calculateSalary(employee)
      println(s"${employee.getClass.getSimpleName} salary: ${salary}%.2f")
    }
  }
}
