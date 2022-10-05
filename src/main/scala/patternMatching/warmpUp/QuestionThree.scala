package io.turntabl
package patternMatching.warmpUp

object QuestionThree extends App {

    def collectionMatcher[T](arg: T): Int = {
      val result = arg match {
        case str: String => str.length
        case col: List[Int] => col.size
        case col: Vector[Int] => col.size
        case col: Map[Int, Int] => col.size
        case _ => -1
      }

      result
    }

}
