import scala.io.Source
object stateWiseGDPAnalysis{
  def main(args: Array[String]): Unit = {
    val filePath = "C:\\Users\\Administrator\\Desktop\\Scala\\statewiseGDP.csv"
    val source = Source.fromFile(filePath)

    //1.Find States with highest GDP
    //2.Find average GDP per capita
    //3.Total GDP
    for (line <- source.getLines()) {
      val columns = line.split(",")
      columns.foreach(println)
    }

    // Get csv datum

  }

}