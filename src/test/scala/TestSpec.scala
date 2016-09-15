/**
  * sbt dependencies:
  * libraryDependencies ++= Seq(
    "com.github.alexarchambault" %% "scalacheck-shapeless_1.13" % "1.1.1",
    "org.specs2" %% "specs2-core" % "3.8.4" % "test",
    "org.specs2" %% "specs2-mock" % "3.8.4" % "test")
  *
  * TO REPLICATE
  * `sbt test`
  * the compiler complains with could not find implicit value for parameter e: org.scalacheck.Arbitrary[BigExample]
  *
  * even crazier....if you copy and paste the code from lines 23-33 in a scala REPL it works!
  * */

import org.specs2.mutable._

class TestSpec extends SpecificationLike {

  "RandomDataGenerator" should {

    "generate a random instance of a case class with more than 22 fields" in {
      import org.scalacheck._
      import org.scalacheck.Shapeless._

      case class BigExample(f1: String, f2: Int, f3: Long, f4: Char, f5: String,
                            f6: String, f7: Int, f8: Long, f9: Char, f10: String,
                            f11: String, f12: Int, f13: Long, f14: Char, f15: String,
                            f16: String, f17: Int, f18: Long, f19: Char, f20: String,
                            f21: String, f22: Int, f23: Long, f24: Char, f25: String,
                            f26: String, f27: Int, f28: Long, f29: Char, f30: String)

      implicitly[Arbitrary[BigExample]]
    }
  }
}


