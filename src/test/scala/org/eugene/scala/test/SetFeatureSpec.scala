package org.eugene.scala.test

import org.scalatest._

/**
 *
 * @author Eugene Wang
 * @since 15/9/5
 */

class TVSet {
  private var on: Boolean = false
  def isOn: Boolean = on
  def pressPowerButton() {
    on = !on
  }
}

class SetFeatureSpec extends FeatureSpec with GivenWhenThen {
  info("As a TV set owner")
  info("I want to be able to turn the TV on and off")
  info("So I can watch TV when I want")
  info("And save energy when I'm not watching TV")
  feature("TV new button") {
    scenario("User press power button when TV is off") {
      Given("a TV set that is switched off")
      val tv = new TVSet
      assert(!tv.isOn)

      When("then power button is pressed")
      tv.pressPowerButton()

      Then("the TV should switch on")
      assert(tv.isOn)
    }
  }
}
