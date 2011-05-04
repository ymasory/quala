package quala.util.parsing.json

import quala.epfl

import scala.util.parsing.json.JSON

import org.scalatest.FunSuite

class JSONTest extends FunSuite {

  test("`JSON.parse` handles strings") {
    JSON parse "{\"Name\": \"va1ue\"}"
  } : @epfl(136)
}
