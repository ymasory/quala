package quala.collection.immutable.list

import scala.collection.immutable.List

import org.scalacheck._

object ListTests extends Properties("List") {
  property("isEmpty") = Prop.forAll( (a: List[Int]) =>
    if (a.length == 0) a isEmpty else !(a.isEmpty)
  )
}

