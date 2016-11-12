import scala.collection.mutable.ArrayBuffer

val a = ArrayBuffer(1, -1, 2, -2, 3, -3)
var first = true
val indexes = for (i <- 0 until a.length if first || a(i) > 0) yield {
  if (a(i) < 0) first = false; i
}
for (j <- 0 until indexes.length) a(j) = a(indexes(j))
a.trimEnd(a.length - indexes.length)
a