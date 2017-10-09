package com.codetest.service

import com.codetest.model.BasePrice
import com.codetest.util.ErrorOps._
import com.codetest.util.util.ErrorOr
import io.circe.generic.auto._
import io.circe.parser.decode

object PriceParser {
  def apply(priceJsonStr: String): ErrorOr[Vector[BasePrice]] = decode[Vector[BasePrice]](priceJsonStr).left.map(_.toError)
}
