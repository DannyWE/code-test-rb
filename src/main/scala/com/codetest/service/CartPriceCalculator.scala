package com.codetest.service

object CartPriceCalculator {
  def apply(basePrice: Long,
            artistMarkUp: Double,
            quantity: Long): Long = {
    val singleItemPrice = basePrice + Math.floor(basePrice * (artistMarkUp / 100 )).toLong
    singleItemPrice * quantity
  }
}
