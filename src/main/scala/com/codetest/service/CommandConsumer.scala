package com.codetest.service

import com.codetest.error.InvalidInput
import com.codetest.util.util.ErrorOr

object CommandConsumer {
  def apply(args: Array[String]): ErrorOr[(String, String)] = {
    args.toList match {
      case cartJsonFile :: priceJsonFile :: Nil =>
        Right((cartJsonFile, priceJsonFile))
      case _ =>
        Left(InvalidInput())
    }
  }
}
