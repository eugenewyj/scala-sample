/**
  *
  * @author Eugene Wang
  * @since 2016/11/12
  */
class Marker private (val color: String) {
  println("Creating " + this)

  override def toString: String = "marker color " + color
}

object Marker {
  private val markers = Map(
    "red" -> new Marker("red"),
    "blue" -> new Marker("blue"),
    "green" -> new Marker("green")
  )

  def getMarker(color: String) = if (markers.contains(color)) markers(color) else null
}
println(Marker getMarker "blue")
println(Marker getMarker "blue")
println(Marker getMarker "red")
println(Marker getMarker "red")
