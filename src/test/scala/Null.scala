package quala

import org.scalatest.FunSuite

class Null extends FunSuite {
  
  test("null has a hashcode") {
    null.##
  } : @epfl(4311)
}
