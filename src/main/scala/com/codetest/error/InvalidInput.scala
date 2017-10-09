package com.codetest.error

final case class InvalidInput() extends Throwable {
  override def getMessage() =
    s"""
       | The Command take two command-line arguments
       | 1. a JSON file path representing a cart, and
       | 2. a JSON file path representing a list of base prices.
     """.stripMargin
}
