import scala.io.Source
import scala.collection.mutable

object FileProcessing {

  def wordCount(filePath: String, topN: Int): List[(String, Int)] = {
    val source = Source.fromFile(filePath)
    val lines = try source.getLines().toList finally source.close()

    val wordCounts = mutable.Map[String, Int]().withDefaultValue(0)

    lines.foreach { line =>
      val words = line.split("\\W+").filter(_.nonEmpty)
      words.foreach { word =>
        val normalizedWord = word.toLowerCase
        wordCounts(normalizedWord) += 1
      }
    }

    val sortedWordCounts = wordCounts.toList.sortBy(-_._2)
    sortedWordCounts.take(topN)
  }

  def main(args: Array[String]): Unit = {
    println("Enter the path to the text file:")
    val filePath = scala.io.StdIn.readLine()

    println("Enter the number of top most frequent words to display:")
    val topN = scala.io.StdIn.readInt()

    val topWords = wordCount(filePath, topN)

    println(s"Top $topN most frequent words:")
    topWords.foreach { case (word, count) =>
      println(s"$word: $count")
    }
  }
}
