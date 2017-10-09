package com.codetest.model

final case class CartProduct(`product-type`: String,
                             options: Map[String, String],
                             `artist-markup`: Long,
                             quantity: Long)
