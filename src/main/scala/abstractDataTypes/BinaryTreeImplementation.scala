package io.turntabl
package abstractDataTypes

// trait with contravariance behaviour
sealed trait BinaryTree[+T] {
  def value: T
  def left: BinaryTree[T]
  def right: BinaryTree[T]
  def size: Int
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](f: T => B): BinaryTree[B]
  def reduce[S >: T](f: (S, S) => S): S
  def forEach[S >: T](f: S => Unit): Unit
}

// a childless node is also known as a leaf
case class Leaf[T](v: T) extends BinaryTree[T] {
  override def value: T = v

  override def left: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the left child of a leaf")

  override def right: BinaryTree[Nothing] = throw new NoSuchElementException("Error accessing the right child of a leaf")

  override def size: Int = 1

  override def printElements: String = v.toString

  override def map[B](f: T => B): BinaryTree[B] = Leaf(f(value))

  override def reduce[S >: T](f: (S, S) => S): S = value

  override def forEach[S >: T](f: S => Unit): Unit = f(value)
}

// a branch has is made up of three parts: the element itself, a left child node and a right child node
case class Branch[T](l: BinaryTree[T], r: BinaryTree[T]) extends BinaryTree[T] {
  override def value: T = throw new NoSuchElementException("No value for a branch")

  override def left: BinaryTree[T] = l

  override def right: BinaryTree[T] = r

  override def size: Int = left.size + right.size

  override def printElements: String =
    left.printElements + ", " + right.printElements

  override def map[B](f: T => B): Branch[B] = Branch(left.map(f), right.map(f))

  override def reduce[S >: T](f: (S, S) => S): S = {
//
////    def reduceAcc(node: BinaryTree[T], f: S => S, acc: S): S = node match {
////      case Leaf(v) => f(v)
////      case Branch(v, l, _) => reduceAcc(l, f, v) + reduceAcc(r, f, _)
////    }
//
////    reduceAcc(this, value)
    ???
  }

  override def forEach[S >: T](f: S => Unit): Unit = {
    left.forEach(f)
    right.forEach(f)
  }

}

object BinaryTree {

  def main(args: Array[String]): Unit = {
    val treeOne: Branch[Int] = Branch(
      Branch(Branch(Leaf(2), Leaf(4)), Leaf(6)),
      Branch(Branch(Leaf(8), Leaf(10)), Leaf(12))
    )
    println(s"treeOne : $treeOne")
    println(s"size of treeOne: ${treeOne.size}")

//    val leaf: Leaf[Int] = Leaf(100)
//    leaf.forEach(l => println(s"printing leaf: $l"))

//    val mapped = treeOne.map(_ * 2)
//    println(s"mapped : $mapped")
//
//    treeOne.forEach(a => print(s"printing... $a -- "))
  }

}