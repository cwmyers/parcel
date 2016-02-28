package parcel

import cats._

import cats.std.all._

trait DefaultMonoidInstances {
  implicit val intMonoid = Monoid[Int]
  implicit val longMonoid = Monoid[Long]
  implicit val stringMonoid2 = Monoid[String]
  implicit val doubleMonoid = Monoid[Double]
  implicit val floatMonoid = Monoid[Float]
  implicit val byteMonoid = Monoid[Byte]
}
