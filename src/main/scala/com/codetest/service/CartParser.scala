package com.codetest.service

import com.codetest.model.CartProduct
import com.codetest.util.util.ErrorOr
import io.circe.generic.auto._
import io.circe.parser.decode
import com.codetest.util.ErrorOps._

object CartParser {
  def apply(cartJsonStr: String): ErrorOr[Vector[CartProduct]] = decode[Vector[CartProduct]](cartJsonStr).left.map(_.toError)
}
