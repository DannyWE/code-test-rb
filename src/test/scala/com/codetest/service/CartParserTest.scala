package com.codetest.service

import com.codetest.util.GetResourceContent
import org.scalatest.{FunSuite, Matchers}

class CartParserTest extends FunSuite with Matchers {
  test("Should parse cart json content to List Product") {
    val jsonStr = GetResourceContent("/cart-9363.json").right.get
    val errorOrProducts = CartParser(jsonStr)

    errorOrProducts.isRight should equal(true)

    val allProducts = errorOrProducts.right.get
    allProducts.length should equal(2)

    val firstProduct = allProducts.head
    firstProduct.`product-type` should equal("hoodie")
    firstProduct.options should equal(Map("size" -> "small", "colour" -> "dark", "print-location" -> "front"))
    firstProduct.`artist-markup` should equal(20)
    firstProduct.quantity should equal(2)
  }
}
