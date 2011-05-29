package quala.collection.immutable.list

import scala.collection.immutable.List

import org.scalacheck._

object ListTests extends Properties("List") {
  property("isEmpty") = Prop.forAll( (a: List[Int]) =>
    if (a.length == 0) a isEmpty else !(a.isEmpty)
  )

  property("filter") = Prop.forAll( (a: List[String]) => {
    val filteredList = a.filter(_.contains("a"))
    filteredList.forall(_.contains("a"))
  })

  property("cons") = Prop.forAll( (a: List[Int], b: Int) => {
    (b :: a).startsWith(List(b))
  })

  property("concatenate") = Prop.forAll( (a: List[Int], b: List[Int]) => {
    (a ++ b).startsWith(a) && (a ++ b).endsWith(b)
  })

  property("prepend") = Prop.forAll( (a: List[Int], b: Int) => {
    (b +: a).endsWith(a) && (b +: a).startsWith(List(b))
  })

  property("sum") = Prop.forAll( (a: List[Int]) => {
    (0 /: a)(_+_) == a.sum
  })
  
  property(":::") = Prop.forAll( (a: List[Int], b: List[Int]) => {
    (a ::: b).startsWith(a) && (a ::: b).endsWith(b)
  })

  property("flatten") = Prop.forAll( (a: List[List[Int]]) => {
    a.flatten == a.foldLeft(Nil: List[Int])(_++_)
  })
}

