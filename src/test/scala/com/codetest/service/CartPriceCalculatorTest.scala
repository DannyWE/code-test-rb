package com.codetest.service

import infrastructure.BaseTestSuite

class CartPriceCalculatorTest extends BaseTestSuite {

  val table = Table(
    ("Base Price",   "Artist Mark Up",   "Quantity",    "Expected: Total Price"),

    (1000L,           30.0,                10L,           13000L),
    (10L,             1.0,                 10L,           100L)
  )

  test("should calculate price") {
    forAll(table)((basePrice: Long, artistMarkUp: Double, quantity: Long, expectedTotalPrice: Long) => {
      val totalPrice = CartPriceCalculator(basePrice, artistMarkUp, quantity)

      totalPrice should equal(expectedTotalPrice)
    })
  }
}
