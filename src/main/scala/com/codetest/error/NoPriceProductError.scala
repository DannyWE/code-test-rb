package com.codetest.error

import com.codetest.model.CartProduct

final case class NoPriceProductError(product: CartProduct) extends Throwable {
  override def getMessage() =
    s"""
       | Product cant find any related price.
       | Product type: ${product.`product-type`}
     """.stripMargin
}
