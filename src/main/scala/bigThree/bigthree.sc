
val someList = List(2, 4, 5, 6)

val someListTransformed = someList.map(x => List(x, x * 2))
val someListFlattened = someList.flatMap(x => List(x, x * 2))

println(someListTransformed)

println(someListFlattened)


val numbers = List(1,2,3,4,5)
val chars = List('a','b','c','d')
val colours = List("red", "yellow")

// {number}{char} - {color}

numbers.filter(_ < 5).flatMap(number =>
  chars.flatMap(char =>
    colours.map(colour => s"$number$char - $colour")))

