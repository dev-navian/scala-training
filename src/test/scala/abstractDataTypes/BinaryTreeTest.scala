package io.turntabl
package abstractDataTypes

import org.scalatest.funsuite.AnyFunSuite

class BinaryTreeTest extends AnyFunSuite {
  val leaf: BinaryTree[Int] = Leaf(5);

  val treeOne: Branch[Int] = Branch(
    2,
    Branch(4, Branch(6, Leaf(8), Leaf(10)), Leaf(11)),
    Branch(13, Branch(15, Leaf(18), Leaf(20)), Leaf(22))
  )

  test("left child of a leaf should throw a NoSuchElementException") {
    assertThrows[NoSuchElementException] {
      leaf.left
    }
  }

  test("should return a valid value of a branch") {
    assert(treeOne.value == 2)
    assert(treeOne.value != 3)
  }

  test("the size of a leaf should return 1") {
    assert(leaf.size == 1)
    assert(leaf.size != 0)
  }

  test("should return the appropriate size of a branch") {
    assert(treeOne.size == 11)
  }

}
