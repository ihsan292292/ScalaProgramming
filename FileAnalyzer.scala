import scala.io.Source
import scala.collection.mutable

class FileAnalyzer {
  private var lines: List[String] = List.empty

  def loadFile(filePath: String): Unit = {
    val source = Source.fromFile(filePath)
    try {
      lines = source.getLines().toList
    } finally {
      source.close()
    }
  }

  def wordCount(): Int = {
    lines.flatMap(_.split("\\W+")).count(_.nonEmpty)
  }

  def lineCount(): Int = {
    lines.length
  }

  def characterCount(): Int = {
    lines.mkString("").length
  }

  def averageWordLength(): Double = {
    val words = lines.flatMap(_.split("\\W+")).filter(_.nonEmpty)
    if (words.isEmpty) 0.0 else words.map(_.length).sum.toDouble / words.length
  }

  def mostCommonStartingLetter(): Option[Char] = {
    val letters = lines.flatMap(_.split("\\W+")).filter(_.nonEmpty).map(_.toLowerCase.head)
    if (letters.isEmpty) None else Some(letters.groupBy(identity).mapValues(_.size).maxBy(_._2)._1)
  }

  def wordOccurrences(word: String): Int = {
    lines.flatMap(_.split("\\W+")).count(_.equalsIgnoreCase(word))
  }

  def topNMostFrequentWords(topN: Int): List[(String, Int)] = {
    val wordCounts = mutable.Map[String, Int]().withDefaultValue(0)
    lines.flatMap(_.split("\\W+")).filter(_.nonEmpty).foreach { word =>
      val normalizedWord = word.toLowerCase
      wordCounts(normalizedWord) += 1
    }
    wordCounts.toList.sortBy(-_._2).take(topN)
  }
}

object FileAnalyzerApp extends App {
  val analyzer = new FileAnalyzer()

  println("Enter the path to the text file:")
  val filePath = scala.io.StdIn.readLine()

  analyzer.loadFile(filePath)

  println(s"Total number of words: ${analyzer.wordCount()}")
  println(s"Total number of lines: ${analyzer.lineCount()}")
  println(s"Total number of characters: ${analyzer.characterCount()}")
  println(f"Average word length: ${analyzer.averageWordLength()}%.2f")
  println(s"Most common starting letter: ${analyzer.mostCommonStartingLetter().getOrElse("N/A")}")

  println("Enter a word to find its occurrences:")
  val word = scala.io.StdIn.readLine()
  println(s"Occurrences of '$word': ${analyzer.wordOccurrences(word)}")

  println("Enter the number of top most frequent words to display:")
  val topN = scala.io.StdIn.readInt()
  val topWords = analyzer.topNMostFrequentWords(topN)
  println(s"Top $topN most frequent words:")
  topWords.foreach { case (word, count) =>
    println(s"$word: $count")
  }
}