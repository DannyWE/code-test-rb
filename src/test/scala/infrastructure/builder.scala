package infrastructure

import com.codetest.model.{BasePrice, CartPrice, CartProduct}

object builder {
  val defaultProduct = CartProduct(
    `product-type` = "productType",
    options = Map("size" -> "small"),
    `artist-markup` = 10,
    quantity = 100
  )

  val defaultPrice = BasePrice(
    `product-type` = "productType",
    options = Map("size" -> Vector("small", "large")),
    `base-price` = 10
  )

  val defaultCartPrice = CartPrice(
    `product-type` = "productType",
    options = Map("size" -> "small"),
    totalPrice = 100
  )
}
