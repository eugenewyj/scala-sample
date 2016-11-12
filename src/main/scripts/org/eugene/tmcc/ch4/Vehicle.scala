/**
  *
  * @author Eugene Wang
  * @since 2016/11/12
  */
class Vehicle(val id: Int, val year: Int) {
  override def toString: String = "ID: " + id + " year: " + year
}

class Car(override val id: Int, override val year: Int, var fuelLevel: Int) extends Vehicle(id, year) {
  override def toString: String = super.toString + " Fuel Level: " + fuelLevel
}

val car = new Car(1, 2009, 100)
println(car)
