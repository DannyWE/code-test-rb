package com.codetest.service

import com.codetest.model.{BasePrice, CartProduct, ProductPriceMatchResult}
import infrastructure.BaseTestSuite
import infrastructure.builder._

class ProductPriceMatcherTest extends BaseTestSuite {
  val table = Table(
    ("Product",                       "Price",                                                  "Expected"),

    (defaultProduct,                  defaultPrice,                                              ProductPriceMatchResult(isMatched = true, Some(defaultProduct.options))),
    (defaultProduct
      .copy(`product-type` = "any"),  defaultPrice,                                              ProductPriceMatchResult(isMatched = false, None)),
    (defaultProduct,                  defaultPrice.copy(options = Map("1" -> Vector("1"))),      ProductPriceMatchResult(isMatched = false, None)),
    (defaultProduct
      .copy(options = Map(
        "size" -> "small",
      )),                             defaultPrice.copy(options = Map(
                                                            "size" -> Vector("small", "large"),
                                                            "colour" -> Vector("white")
                                                          )),                                    ProductPriceMatchResult(isMatched = false, None)),
    (defaultProduct
      .copy(options = Map(
        "size" -> "small",
        "colour" -> "white"
      )),                             defaultPrice.copy(options = Map(
                                                            "size" -> Vector("small", "large")
                                                          )),                                    ProductPriceMatchResult(isMatched = true, Some(defaultProduct.options))),
  )

  test("should match product with base price") {
    forAll(table)((product: CartProduct,
                   price: BasePrice,
                   expected: ProductPriceMatchResult
                  ) => {
      ProductPriceMatcher(product, price) should equal(expected)
    })
  }
}
