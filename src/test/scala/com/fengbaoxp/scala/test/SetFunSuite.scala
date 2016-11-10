package com.fengbaoxp.scala.test

import org.scalatest.FunSuite

/**
 *
 * @author Eugene Wang
 * @since 15/9/4
 */
class SetFunSuite extends FunSuite {
  test("An empty Set should have size 0") {
    assert(Set.empty.size == 0)
  }

  test("Invoking head on a empty Set should produce NoSuchElementException") {
    intercept[NoSuchElementException] {
      Set.empty.head
    }
  }
}
