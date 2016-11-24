/**
  *
  * @author Eugene Wang
  * @since 2016/11/12
  */
class Car(val year: Int) {
  private var milesDriven: Int = _

  def miles() = milesDriven

  @throws(classOf[Exception])
  def drive(distance: Int): Unit = {
    milesDriven += Math.abs(distance)
  }
}

val car = new Car(2009)
println("Car made in year " + car.year)
println("Miles driven " + car.miles)
println("Drive for 10 miles")
car.drive(10)
println("Miles driven " + car.miles)