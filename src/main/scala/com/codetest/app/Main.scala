package com.codetest.app

import com.codetest.app.Main.args
import com.codetest.model.CartPrice
import com.codetest.service._
import com.codetest.util.GetFileContent
import com.codetest.util.util.ErrorOr
import io.circe.generic.auto._
import io.circe.syntax._

object Main extends App {
  execute(args) match {
    case Right(t) => println(t)
    case Left(error) => println(error.getMessage)
  }

  def execute(args: Array[String]): ErrorOr[String] = {

    val result: ErrorOr[Vector[CartPrice]] = for {
      files <- CommandConsumer(args)
      cartStr <- GetFileContent(files._1)
      priceStr <- GetFileContent(files._2)
      cartList <- CartParser(cartStr)
      priceList <- PriceParser(priceStr)
      cartPriceList <- CartPriceGenerator(cartList, priceList, ProductPriceMatcher.apply, CartPriceCalculator.apply)
    } yield cartPriceList

    result.map(t => t.asJson.spaces2)
  }
}
