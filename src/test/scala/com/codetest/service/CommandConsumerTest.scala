package com.codetest.service

import com.codetest.error.InvalidInput
import com.codetest.util.util.ErrorOr
import infrastructure.BaseTestSuite

class CommandConsumerTest extends BaseTestSuite {
  val table = Table(
    ("Array Arguments",                           "Expected Result"),

    (Array("1", "2"),                             Right(("1", "2"))),
    (Array("1"),                                  Left(InvalidInput()))
  )

  test("should consume command") {
    forAll(table)((args: Array[String],
                   expected: ErrorOr[(String, String)]) => {

      CommandConsumer(args) should equal(expected)
    })
  }
}
