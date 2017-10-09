package com.codetest.service

import com.codetest.error.NoPriceProductError
import com.codetest.model.{BasePrice, CartPrice, CartProduct, ProductPriceMatchResult}
import com.codetest.util.util.ErrorOr
import infrastructure.BaseTestSuite
import infrastructure.builder._

class CartPriceGeneratorTest extends BaseTestSuite {
  val dummyMatcher: (CartProduct, BasePrice) => ProductPriceMatchResult = (t, r) =>
    ProductPriceMatchResult(isMatched = t.`product-type`.equals(r.`product-type`), None)
  val dummyCalculator: (Long, Double, Long) => Long = (_, _, _)  => 100

  val table = Table(
    ("Cart Product",                "Base Price List",                                    "Total Price"),

    (defaultProduct,                Vector(defaultPrice),                                 Right(defaultCartPrice)),
    (defaultProduct,                Vector(defaultPrice.copy(`product-type` = "any")),    Left(NoPriceProductError(defaultProduct)))
  )

  test("should generate cart price based on product, base price list and calculator") {
    forAll(table)((product: CartProduct,
                   priceList: Vector[BasePrice],
                   expected: ErrorOr[CartPrice]) => {
      CartPriceGenerator.generateEach(product, priceList, dummyMatcher, dummyCalculator) should equal(expected)
    })
  }
}
