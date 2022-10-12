package io.turntabl
package abstractDataTypes

// trait with contravariance behaviour
sealed trait BinaryTree[+T] {
  def value: T
  def left: BinaryTree[T]
  def right: BinaryTree[T]
  def size: Int
  def printElements: String
//  def map[B](f:(T => B)): B
}

// an Empty Node is also known as a leaf
case class Leaf[T](v: T) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the left child of an empty node")

  override def right: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the right child of an empty node")

  override def size: Int = 1

  override def printElements: String = v.toString

//  override def map[B](f: Nothing => B): B = throw new NoSuchElementException("Cannot perform a map operation on an empty node")
}

// a Node has is made up of three parts: the element itself, a left child node and a right child node
case class Branch[T](v: T, l: BinaryTree[T], r: BinaryTree[T]) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[T] = l

  override def right: BinaryTree[T] = r

  override def size: Int = 1 + l.size + r.size

  override def printElements: String =
    "[" + v.toString + ", " + l.printElements + ", " + r.printElements + "]"

}

object BinaryTree {

  def main(args: Array[String]): Unit = {

//    val treeOne = Branch(
//      2,
//      Branch(4, Branch(6, Leaf(8), Leaf(10)), Leaf(11)),
//      Branch(13, Branch(15, Leaf(18), Leaf(20)), Leaf(22))
//    )
//
//    println(treeOne.size)
//    println(treeOne.printElements)
  }


}