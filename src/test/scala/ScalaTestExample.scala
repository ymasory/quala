package quala

import org.scalatest.FunSuite

class QualaTest extends FunSuite {

  test("quala dummy test works") {
    assert(1 === 1)

    expect(1) {
      2 - 1
    }

    intercept[IllegalArgumentException] {
      throw new IllegalArgumentException()
    }
  }
}
