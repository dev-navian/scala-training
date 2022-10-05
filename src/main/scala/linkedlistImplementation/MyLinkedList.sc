/**
 * Scala has a built in LinkedList under the List class, the aim here is to build our own (simplified) version
 * of a Linked List called MyLinkedList
 *
 * Exercises:
 *   1) Define a trait (MyLinkedList) and appropriate case classes and case objects for our linkedList to represent empty and non-empty
 *   2) Create a method head that returns the first element of our List
 *   3) Create a method tail that returns the remaining elements of our List
 *   4) Create a method isEmpty that returns whether our List is empty or not
 *   5) Create a method to add an element to a list, call this method :: as is standard in the Scala List Library
 *   6) Create a toString method that will return a string representation of the List with commas between each element e.g. [1,2,3,4,5]
 *   7) Create the appropriate method so that a List can be created with elements easily, i.e. val list = MyLinkedList(1,2,3,4,5)
 *
 * Notes: The List must be immutable.
 *
 */

sealed trait MyLinkedList[+T] {
  def head: T
  def tail: MyLinkedList[T]
  def isEmpty: Boolean
  def ::[S >: T](element :S): MyLinkedList[S] // Add method
  def printElements: String
  override def toString: String = "[" + printElements + "]"
}

// Empty
case object Empty extends MyLinkedList[Nothing] {
  override def head: Nothing = throw new NoSuchElementException("Head of empty MyLinkedList")
  override def tail: MyLinkedList[Nothing] = throw new NoSuchElementException("Attempt to access tail of empty MyLinkedList")
  override def isEmpty: Boolean = true
  override def ::[S >: Nothing](element: S): MyLinkedList[S] = Cons(element, Empty)
  override def printElements: String = ""
}

// Cons
case class Cons[T](h: T, t: MyLinkedList[T]) extends MyLinkedList[T] {
  override def head: T = h
  override def tail: MyLinkedList[T] = t
  override def isEmpty: Boolean = false
  override def ::[S >: T](element: S): MyLinkedList[S] = Cons(element, this)
  override def printElements: String =
    if(t.isEmpty) head.toString
    else head.toString + "," + tail.printElements
}


object MyLinkedList {

  def apply[T](items: T*): MyLinkedList[T] = ???

  def main(args: Array[String]): Unit = {
    val myList: MyLinkedList[Int] = Cons(1, Cons(2, Cons (3, Empty)))
    val myList2: MyLinkedList[Int] = 1 :: 2 :: 3 :: 4 :: Empty

    val calvinsList = MyLinkedList(1,2,3,4,5,6,7,8,9,10)

    val myEmptyList = Empty
    println(myList2) // [1,2,3,4]
    println(myEmptyList)

  }
}

