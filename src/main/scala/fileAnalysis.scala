

import scala.io.Source
object fileAnalysis{
  def main(args: Array[String]): Unit = {
    val filePath = "C:\\Users\\Administrator\\IdeaProjects\\helloWorldScala\\src\\main\\scala\\test"
    val source = Source.fromFile(filePath)

    // Get most frequent word count.
    val lines = source.getLines().toList
    val words = lines.flatMap(_.split("\\s+")).map(_.toLowerCase)
    val groupWord = words.groupBy(identity)
    val wordCount = groupWord.mapValues(_.size).toSeq.sortBy(-_._2)
    wordCount.take(10).foreach{case(word,count)=>println(s"$word:$count")}
    source.close()

    //2.Average word length
    val totalWords = words.length
    val totalChar = words.map(_.length).sum
    val avgWordLength = if (totalWords>0)
      totalChar.toDouble/totalWords else 0.0

    println("Total Words : "+totalWords)
    println("Total Char : "+totalChar)
    println("Average word length : "+avgWordLength)
  }

}