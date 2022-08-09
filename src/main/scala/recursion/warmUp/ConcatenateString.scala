package io.turntabl
package recursion.warmUp

import scala.annotation.tailrec

object ConcatenateString extends App {

  def concatenateString(string: String, numberOfTimes: Int): String = {

    if (numberOfTimes < 1) string

    else string + concatenateString(string, numberOfTimes - 1)
  }

  def concatenateStringTailRecursion(string: String, numberOfTimes: Int): String = {

    @tailrec
    def concatenateString(string: String, numberOfTimes: Int, acc: String): String = {
      if (numberOfTimes < 1) acc;

      else concatenateString(string, numberOfTimes - 1, string + acc);
    }

    concatenateString(string, numberOfTimes, string);
  }

}
