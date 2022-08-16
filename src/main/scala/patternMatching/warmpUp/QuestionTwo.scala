package io.turntabl
package patternMatching.warmpUp

object QuestionTwo {

  def listMatcher(listOfNumbers: List[Int]): Int = {

    val result = listOfNumbers match {
      case List() => 0
      case List(_, _, x) => x
      case head :: tail => head
    }

    result
  }

}
