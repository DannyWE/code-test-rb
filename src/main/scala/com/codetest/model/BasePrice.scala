package com.codetest.model

final case class BasePrice(`product-type`: String,
                           options: Map[String, Vector[String]],
                           `base-price`: Long)