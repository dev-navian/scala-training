package io.turntabl
package linkedlistImplementation


/*
  +T indicates covariance
    eg. if a Dog class extends an Animal trait, then a list of dogs is a list of animals
*/
sealed trait MyLinkedList[+T] {
  def head: T
  def tail: MyLinkedList[T]
  def isEmpty: Boolean
  def ::[S >: T](element: S) : MyLinkedList[S]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

case object EmptyList extends MyLinkedList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException("head of an empty linked list")

  override def tail = throw new NoSuchElementException("access to the tail of an empty linked list")

  override def isEmpty: Boolean = true

  override def ::[S >: Nothing](element: S): MyLinkedList[S] = Cons(element, EmptyList)

  override def printElements: String = ""
}

case class Cons[T](h: T, t: MyLinkedList[T]) extends MyLinkedList[T] {
  override def head: T = h

  override def tail: MyLinkedList[T] = t

  override def isEmpty: Boolean = false

  override def ::[S >: T](element: S): MyLinkedList[S] = Cons(element, this)

  override def printElements: String =
    if (t.isEmpty) head.toString
    else head.toString + ", " + tail.printElements
}

object MyLinkedList {

  def apply[T](items: T*): MyLinkedList[T] =
    if (items.isEmpty) EmptyList
    else Cons(items.head, apply(items.tail: _*))

  def main(args: Array[String]): Unit = {
    val someLinkedList: MyLinkedList[Int] = Cons[Int](101, Cons(204, Cons(306, EmptyList)))

    val listHead: Int = someLinkedList.head;
    val listTail: MyLinkedList[Int] = someLinkedList.tail

    println(someLinkedList)
    println(s"list head => $listHead")
    println(s"list tail => $listTail")

    val anotherLinkedList: MyLinkedList[Int] = 55 :: 33 :: 22 :: 44 :: EmptyList
    println(anotherLinkedList)

    val emptyLinkedList: MyLinkedList[Nothing] = EmptyList
    println(s"empty list $emptyLinkedList")

    val ownConstruct: MyLinkedList[Int] = MyLinkedList(30, 60, 90, 120, 180, 150)
    println(ownConstruct)

  }


}