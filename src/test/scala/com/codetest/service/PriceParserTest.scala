package com.codetest.service

import com.codetest.util.GetResourceContent
import org.scalatest.{FunSuite, Matchers}

class PriceParserTest extends FunSuite with Matchers {
  test("should parse base price list") {
    val jsonStr = GetResourceContent("/base-prices.json").right.get
    val errorOrPrice = PriceParser(jsonStr)

    errorOrPrice.isRight should equal(true)

    val allPrice = errorOrPrice.right.get
    allPrice.length should equal(10)

    val firstPrice = allPrice.head
    firstPrice.`product-type` should equal("hoodie")
    firstPrice.options should equal(Map("colour" -> List("white", "dark"), "size" -> List("small", "medium")))
    firstPrice.`base-price` should equal(3800)
  }
}
