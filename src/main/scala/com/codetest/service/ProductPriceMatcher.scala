package com.codetest.service

import com.codetest.model.{BasePrice, CartProduct, ProductPriceMatchResult}

object ProductPriceMatcher {

  def apply(product: CartProduct, basePrice: BasePrice): ProductPriceMatchResult = {
    (product, basePrice) match {
      case (CartProduct(t, _, _, _),
      BasePrice(r, _, _)) if !t.equals(r) => ProductPriceMatchResult(isMatched = false, None)
      case (CartProduct(_, productOptions, _, _),
      BasePrice(_, priceOptions, _)) => compare(priceOptions, productOptions)
    }
  }

  private def compare(priceOptions: Map[String, Vector[String]],
                      productOptions: Map[String, String]): ProductPriceMatchResult = {
    val isMatched = priceOptions.forall(price => productOptions.contains(price._1)
      && productOptions(price._1).contains(productOptions(price._1)))

    if (isMatched) {
      return ProductPriceMatchResult(isMatched = true,
        Some(priceOptions.map(entry => entry._1 -> productOptions(entry._1))))
    }
    ProductPriceMatchResult(isMatched = false, None)
  }
}
