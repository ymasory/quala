package quala

import org.scalacheck._

object ScalaCheckExample extends Properties("String") {

  property("startsWith") = Prop.forAll( (a: String, b: String) =>
    (a+b).startsWith(a)
  )
}
