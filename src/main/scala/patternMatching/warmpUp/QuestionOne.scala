package io.turntabl
package patternMatching.warmpUp

object QuestionOne {

  def main(args: Array[String]): Unit = {
    val someVal: Int = 80

    val intMatcher = someVal match {
      case x if x < 0 => "less than 0"
      case x if x >= 0 && x <= 18 => "from 0 to 18"
      case x if x >= 19 && x <= 35 => "from 19 to 35"
      case x if x >= 36 && x <= 65 => "from 36 to 65"
      case x if x > 65 => "greater than 65"
    }

    println(intMatcher)


  }




}
