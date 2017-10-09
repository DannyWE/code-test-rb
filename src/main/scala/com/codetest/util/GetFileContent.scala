package com.codetest.util

import java.io.{FileInputStream, InputStream}

import com.codetest.util.util.ErrorOr

import scala.util.Try

object GetFileContent {
  def apply(path: String): ErrorOr[String] = {
    Try {
      val stream : InputStream = new FileInputStream(path)
      scala.io.Source.fromInputStream( stream ).getLines.toList.mkString("\n")
    }.toEither
  }
}
