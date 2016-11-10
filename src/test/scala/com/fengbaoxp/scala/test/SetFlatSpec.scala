package com.fengbaoxp.scala.test

import org.scalatest.FlatSpec

/**
 *
 * @author Eugene Wang
 * @since 15/9/4
 */
class SetFlatSpec extends FlatSpec {
  "一个空Set" should "size为0" in {
    Set.empty.size == 0
  }

  it should "produce NoSuchElementException when head is invoked" in {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }
}
