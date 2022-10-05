package io.turntabl
package patternMatching.warmpUp

object QuestionFive {

  def main(args: Array[String]): Unit = {
    val someArr: Array[Int] = Array(2, 3, 5, 3)
    val res = swap(someArr).mkString("Array(", ", ", ")")

    println(res)
  }

  def swap(arr: Array[Int]): Array[Int] = {

    arr match {
//      case Array(x, y, _*) => Array(y, x, _)
      case _ => arr
    }
  }

}
