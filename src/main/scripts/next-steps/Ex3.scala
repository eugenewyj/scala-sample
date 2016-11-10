val greetStrings = new Array[String](3)
greetStrings.update(0, "Hello")
greetStrings.update(1, ", ")
greetStrings.update(2, "world!\n")
for (i <- 0 to 2)
  print(greetStrings(i))

val numNames = Array("zero", "one", "two")
numNames.foreach(println)

val numNames2 = Array.apply("zero", "one", "two")
numNames2.foreach(println)

val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour
println("" + oneTwo + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list.")

val twoThree = List(2, 3)
val oneTwoThree = 1 :: twoThree
println(oneTwoThree)

val oneTwoThree2 = 1 :: 2 :: 3 :: Nil
println(oneTwoThree2)

val pair = (99, "Luftballons")
println(pair._1)
println(pair._2)

var jetSet = Set("aaa", "bbb")
jetSet += "ccc"
println(jetSet.contains("ddd"))
println(jetSet.contains("ccc"))
