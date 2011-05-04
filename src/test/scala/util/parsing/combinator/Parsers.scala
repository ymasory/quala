package quala.util.parsing.combinator

import quala.epfl

import org.scalacheck._

import scala.util.parsing.combinator._

object RegexParsersTest extends Properties("String") with RegexParsers {

  lazy val acceptAnyString: Parser[String] = ".*".r

  property(acceptAnyString.toString + " accepts all Strings") = Prop.forAll {
    a: String => {
      parseAll(acceptAnyString, a) match {
        case Success(res, _) => res == a
        case NoSuccess(_, _) => false
      }
    }
  }

  property("`literal` accepts any matching String") = Prop.forAll {
    a: String => {
      val literalParser = literal(a)
      parseAll(literalParser, a) match {
        case Success(res, _) => res == a
        case NoSuccess(_, _) => false
      }
    }
  }
}
