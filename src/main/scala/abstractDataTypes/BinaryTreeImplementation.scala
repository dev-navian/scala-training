package io.turntabl
package abstractDataTypes

// trait with contravariance behaviour
sealed trait BinaryTree[+T] {
  def value: T
  def left: BinaryTree[T]
  def right: BinaryTree[T]
  def size: Int
}

// an Empty Node is also known as a leaf
case object Leaf extends BinaryTree[Nothing] {
  override def value: Nothing = throw new NoSuchElementException("Error accessing the value of an empty node")

  override def left: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the left child of an empty node")

  override def right: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the right child of an empty node")

  override def size: Int = 0
}

// a Node has is made up of three parts: the element itself, a left child node and a right child node
case class Branch[T](v: T, l: BinaryTree[T], r: BinaryTree[T]) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[T] = l

  override def right: BinaryTree[T] = r

  override def size: Int = {
    def calculateSize(node: BinaryTree[T]): Int = node match {
      case Leaf => 1
      case Branch(v, l , r) => 1 + calculateSize(l) + calculateSize(r)
    }

    calculateSize(this)
  }
}

object BinaryTree {

  def main(args: Array[String]): Unit = {

  }


}