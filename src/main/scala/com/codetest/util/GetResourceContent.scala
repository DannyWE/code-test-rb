package com.codetest.util

import java.io.InputStream

import com.codetest.util.util.ErrorOr

import scala.util.Try

object GetResourceContent {
  def apply(path: String): ErrorOr[String] = {
    Try {
      val stream : InputStream = getClass.getResourceAsStream(path)
      scala.io.Source.fromInputStream( stream ).getLines.toList.mkString("\n")
    }.toEither
  }
}
