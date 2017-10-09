package com.codetest.service

import com.codetest.error.NoPriceProductError
import com.codetest.model.{BasePrice, CartPrice, CartProduct, ProductPriceMatchResult}
import com.codetest.util.util.ErrorOr

object CartPriceGenerator {
  def apply(productList: Vector[CartProduct],
            priceList: Vector[BasePrice],
            matcher: (CartProduct, BasePrice) => ProductPriceMatchResult,
            calculator: (Long, Double, Long) => Long): ErrorOr[Vector[CartPrice]] = {
    val errorOrCartPriceList = productList.map(t => generateEach(t, priceList, matcher, calculator))
    val errorProduct = errorOrCartPriceList.find(_.isLeft)
    errorProduct match {
      case Some(Left(error)) => Left(error)
      case _ => Right(errorOrCartPriceList.map(_.right.get))
    }
  }

  def generateEach(product: CartProduct,
                   priceList: Vector[BasePrice],
                   matcher: (CartProduct, BasePrice) => ProductPriceMatchResult,
                   calculator: (Long, Double, Long) => Long): ErrorOr[CartPrice] = {
    val optionCartPrice = priceList.find(price => matcher(product, price).isMatched)
      .map(t => CartPrice(t.`product-type`, product.options,
        calculator(t.`base-price`, product.`artist-markup`, product.quantity)))
    optionCartPrice match {
      case Some(t) => Right(t)
      case None => Left(NoPriceProductError(product))
    }
  }
}
