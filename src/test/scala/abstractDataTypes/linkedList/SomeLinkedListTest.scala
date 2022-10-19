package io.turntabl
package abstractDataTypes.linkedList

import org.scalatest.funsuite.AnyFunSuite

class SomeLinkedListTest extends AnyFunSuite {

  val listOne = SomeLinkedList(22, 55, 66, 88, 44, 77, 99, 111, 33)
  val listTwo = SomeLinkedList(100, 120, 155, 180, 213, 270, 320, 355)

  test("should return the head of the linked list") {
    val listHead = listOne.head

    assert(listHead == 22)
    assert(listHead != 33)
  }

  test("should return the tail of the linked list") {
    val listTail = !listOne.tail.isEmpty

    assert(listTail)
  }

  test("should add another element to the list") {
    val newList = 123 :: listOne

    assert(newList.head == 123)
  }

  test("should return 9 as the length of the list") {
    val listLength = listOne.length

    assert(listLength == 9)
  }

  test("should return list of even numbers") {
    val newList = listOne.filter(_ % 2 == 0)
    val expectedList = SomeLinkedList(22, 66, 88, 44)

    assert(newList == expectedList)
  }

  test("should reverse the list") {
    val reversed = listOne.reverse
    val expected = SomeLinkedList(33, 111, 99, 77, 44, 88, 66, 55, 22)

    assert(reversed == expected)
  }

  test("should fold the list") {
    val folded = listOne.fold(0)(_ + _)
    val expected = 595

    assert(folded == expected)
    assert(folded != 550)
  }

  test("should return a partitioned list") {
    val partitioned = listTwo.partition(_ % 2 != 0)

    assert(partitioned._1 == SomeLinkedList(155, 213, 355))
    assert(partitioned._2 == SomeLinkedList(100, 120, 180, 270, 320))
  }

  test("should sort the list") {
    val sorted = listOne.sort(_ - _)
    val expected = SomeLinkedList(22, 33, 44, 55, 66, 77, 88, 99, 111)

    assert(sorted == expected)
  }
}
