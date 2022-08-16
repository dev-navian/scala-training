package io.turntabl
package patternMatching.warmpUp

object Briefing {

  def main(args: Array[String]): Unit = {

    val someTuple = (4, 2)
    val tupleMatch = someTuple match {
      case (1, x) => s"this matches tuple (1, x: $x)"
      case (x, 2) => s"this matches tuple (x: $x, 2)"
    }

    println(tupleMatch)

    ////////////////////////////////////////////////////////////

    val someList = List(1, 2, 3, 4)
    val listMatch = someList match {
      case 1 :: tail => s"List starting with 1 and has the rest as $tail"
      case List(1, _*) :+ 4 => "Linked List ending with 4"
      case List(1, _, _, _) => "List with 4 elements starting with 1"
    }

    println(listMatch)

    ////////////////////////////////////////////////////////////

    val someNumber: Int = 12

    val intMatch = someNumber match {
      case x if x > 30 => s"$x is greater than 30"
      case x if x > 40 => s"$x is greater than 30"
      case _ => "must be any number less than 30 or 40"
    }

    println(intMatch)

    ////////////////////////////////////////////////////////////

  }
}
