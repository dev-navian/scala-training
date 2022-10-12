package io.turntabl
package abstractDataTypes

import org.scalatest.funsuite.AnyFunSuite

class BinaryTreeTest extends AnyFunSuite {
  val firstLeaf: BinaryTree[Nothing] = Leaf;

  val firstBranch: BinaryTree[Int] = Branch(
    2,
    Branch(3, Leaf, Leaf),
    Branch(4, Branch(5, Leaf, Leaf), Leaf)
  )

  test("value of a leaf should throw a NoSuchElementException") {
    assertThrows[NoSuchElementException] {
      firstLeaf.value
    }
  }

  test("should return a valid value of a branch") {
    assert(firstBranch.value == 2)
    assert(firstBranch.value != 3)
  }

  test("the size of a leaf should return 0") {
    assert(firstLeaf.size == 0)
  }

  test("should return the appropriate size of a branch") {
    assert(firstBranch.size == 9)
  }

}
