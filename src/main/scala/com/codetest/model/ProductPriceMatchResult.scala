package com.codetest.model

final case class ProductPriceMatchResult(isMatched: Boolean,
                                         options: Option[Map[String, String]])
