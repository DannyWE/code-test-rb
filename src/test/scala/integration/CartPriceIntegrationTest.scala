package integration

import com.codetest.app.Main
import org.scalatest.{FunSuite, Matchers}

class CartPriceIntegrationTest extends FunSuite with Matchers {
  test("should generate json string based on product json and price json") {
    val cartJsonFilePath = getClass.getResource("/cart-4560.json").getFile
    val priceJsonFilePath = getClass.getResource("/base-prices.json").getFile

    val result = Main.execute(Array(cartJsonFilePath, priceJsonFilePath))

    result should equal(Right(
      """[
        |  {
        |    "product-type" : "hoodie",
        |    "options" : {
        |      "size" : "small",
        |      "colour" : "white",
        |      "print-location" : "front"
        |    },
        |    "totalPrice" : 4560
        |  }
        |]""".stripMargin))
  }

  def getFilePath(resourceJsonPath: String): String = getClass.getResource(resourceJsonPath).getFile
}
