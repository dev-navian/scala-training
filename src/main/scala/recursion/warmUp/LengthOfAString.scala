package io.turntabl
package recursion.warmUp

import scala.annotation.tailrec

object LengthOfAString extends App {

  def findTheLengthOfAString(string: String, index: Int = 0): Int = {
    if (index == string.length) 0

    else 1 + findTheLengthOfAString(string, index + 1);
  }


  def findTheLengthOfAStringTailRecursively(string: String): Int = {

    @tailrec
    def findTheLengthOfAString(string: String, acc: Int): Int = {
      if (acc == string.length) acc;

      else findTheLengthOfAString(string, acc + 1);
    }

    findTheLengthOfAString(string, 0);
  }

}
