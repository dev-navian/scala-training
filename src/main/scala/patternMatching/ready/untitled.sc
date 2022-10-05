import java.io.File
import scala.annotation.tailrec

def filesHere: Array[File] = (new File(".")).listFiles

def filesMatching(func: (String, String) => Boolean): String => Array[File] = {
  @tailrec
  def filesMatchingAcc(query: String)(fileArray: Array[File], accFileArray: Array[File]): Array[File] = {
    if (fileArray.isEmpty) accFileArray
    else filesMatchingAcc(query)(fileArray.tail,
      if (func(fileArray.head.getAbsolutePath, query)) accFileArray :+ fileArray.head
      else accFileArray
    )
  }

  (query: String) => filesMatchingAcc(query)(filesHere, Array())
}

val endsWith = filesMatching(_ endsWith _)
endsWith("")


// write a function that takes an Int and returns another function that takes an Int
// and returns and Int

// Function Signature : Function1[Int, Function1[Int, Int]]

val composed = new Function[Int, Function[Int, Int]] {
  override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
    override def apply(y: Int): Int = y * x
  }
}


def doMath(a: Int): Int => Int = {
  println(s"value of a = ${a} \n")
  (x) => x * 3
}

val multiply = doMath(3)
println( multiply(2) )

println( doMath(2)(5) )
//def multiplyByThree(x: Int): Int = x * 3

@tailrec
def nTimes(func: Int => Int, n: Int, x: Int): Int = {
  if (n < 1) x

  else nTimes(func, n - 1, func(x))
}

val plusTwo = (x: Int) => x + 2

val res = nTimes(plusTwo, 3, 2)
println(res)


def nTimesBetter(func: Int => Int, n: Int): Int => Int = {
  if (n < 1) (x: Int) => x
  else (x: Int) => nTimesBetter(func, n - 1)(func(x))
}

val plusTen = (x: Int) => x + 10
val res = nTimesBetter(plusTen, 3)

println( res(2) )


val someCurried: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

println( someCurried(3)(10) ) // will return y => 3 + y