package io.turntabl
package patternMatching.warmpUp

import org.scalatest.funsuite.AnyFunSuite

class QuestionThreeTest extends AnyFunSuite {
    val list: List[Int] = List(2, 3, 4)
    val vector: Vector[Int] = Vector(5, 7, 8, 9, 10)
    val map: Map[Int, Int] = Map(1 -> 4, 2 -> 4, 3 -> 2)

  test("Should return the length of a list if a list is passed") {
    val res = QuestionThree.collectionMatcher(list)
    assert(res == 3)
  }

  test("Should return the size of a vector if a vector is passed") {
    val res = QuestionThree.collectionMatcher(vector)
    assert(res == 5)
    assert(res != 3)
  }

  test("Should return the size of a map if a map is passed") {
    val res = QuestionThree.collectionMatcher(map)
    assert(res == 3)
  }

  test("Should return -1 if any other type is passed") {
    val res = QuestionThree.collectionMatcher("hello")
    assert(res == -1)
  }

}
