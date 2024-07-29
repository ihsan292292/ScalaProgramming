import scala.util.Random
import scala.io.StdIn.readInt

object PasswordGenerator {
  val lowerCaseChars = "abcdefghijklmnopqrstuvwxyz"
  val upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
  val numbers = "1234567890"
  val specialChars = "!@#$%^&*()-_=+[]{}|;:,.<>?/~`"

  val allChars = lowerCaseChars + upperCaseChars + numbers + specialChars

  def generatePassword(length: Int): String = {
    require(length >= 4, "password length should be atleast 4 to include")

    val password = new StringBuilder
    password += lowerCaseChars(Random.nextInt(lowerCaseChars.length))
    password += upperCaseChars(Random.nextInt(upperCaseChars.length))
    password += numbers(Random.nextInt(numbers.length))

    // fill the rest with random
     for (_ <- 4 until length) {
          password += allChars(Random.nextInt(allChars.length))
      }
    // Shuffle the characters to ensure randomness
    Random.shuffle(password).mkString
  }

  def main(args: Array[String]): Unit = {
    println("Enter length for the password:")
    val length = readInt()
    val password = generatePassword(length)
    println(s"Generated password: $password")
  }
}