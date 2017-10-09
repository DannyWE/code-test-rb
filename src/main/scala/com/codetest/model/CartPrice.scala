package com.codetest.model

final case class CartPrice(`product-type`: String,
                           options: Map[String, String],
                           totalPrice: Long )