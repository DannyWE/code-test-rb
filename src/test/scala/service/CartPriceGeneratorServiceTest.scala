package service

import com.codetest.model.CartPrice
import com.codetest.service.{CartPriceCalculator, CartPriceGenerator, ProductPriceMatcher}
import infrastructure.BaseTestSuite
import infrastructure.builder._

class CartPriceGeneratorServiceTest extends BaseTestSuite {
  test("Generate Cart Price Service Test") {
    val hoodie = defaultProduct.copy(`product-type` = "hoodie", `artist-markup` = 30, quantity = 30)
    val hoodiePrice = defaultPrice.copy(`product-type` = "hoodie")
    val basePriceList = Vector(defaultPrice, hoodiePrice)

    val errorOrBasePrice = CartPriceGenerator.generateEach(hoodie,
      basePriceList, ProductPriceMatcher.apply, CartPriceCalculator.apply)

    errorOrBasePrice should equal(Right(CartPrice("hoodie", hoodie.options, 390)))
  }
}
