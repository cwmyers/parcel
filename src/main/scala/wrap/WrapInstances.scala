package wrap

import shapeless.{Generic, ::, HList, HNil}

import cats.std.all._
import cats.Monoid

trait WrapInstances {

  implicit val intMonoid = Monoid[Int]
  implicit val longMonoid = Monoid[Long]
  implicit val stringMonoid2 = Monoid[String]
  implicit val doubleMonoid = Monoid[Double]
  implicit val floatMonoid = Monoid[Float]
  implicit val byteMonoid = Monoid[Byte]

  implicit val stringWrap: WrapString[String] = new WrapString[String] {
    override def wrap(a: String): String = a

    override def unwrap(a: String): String = a
  }

  implicit val intWrap: WrapInt[Int] = new WrapInt[Int] {
    override def wrap(b: Int): Int = b

    override def unwrap(a: Int): Int = a
  }

  implicit val longWrap: WrapLong[Long] = new WrapLong[Long] {
    override def wrap(b: Long): Long = b

    override def unwrap(a: Long): Long = a
  }

  implicit val doubleWrap: WrapDouble[Double] = new WrapDouble[Double] {
    override def wrap(b: Double): Double = b

    override def unwrap(a: Double): Double = a
  }

  implicit val floatWrap: WrapFloat[Float] = new WrapFloat[Float] {
    override def wrap(b: Float): Float = b

    override def unwrap(a: Float): Float = a
  }

  implicit val byteWrap: WrapByte[Byte] = new WrapByte[Byte] {
    override def wrap(b: Byte): Byte = b

    override def unwrap(a: Byte): Byte = a
  }

  implicit val booleanWrap: WrapBoolean[Boolean] = new WrapBoolean[Boolean] {
    override def wrap(b: Boolean): Boolean = b

    override def unwrap(a: Boolean): Boolean = a
  }


  implicit def hnilWrap[B: Monoid]: Wrap[HNil, B] = new Wrap[HNil, B] {
    override def wrap(s: B): HNil = HNil

    override def unwrap(a: HNil): B = implicitly[Monoid[B]].empty
  }

  implicit def hconsWrap[H, T <: HList, B](implicit wrap1: Wrap[H, B], wrap2: Wrap[T, B]): Wrap[H :: T, B] = new Wrap[H :: T, B] {
    override def wrap(b: B): ::[H, T] = {
      val hWrap: Wrap[H, B] = wrap1
      val tWrap: Wrap[T, B] = wrap2
      hWrap.wrap(b) :: tWrap.wrap(b)
    }

    override def unwrap(a: ::[H, T]): B = {
      implicitly[Wrap[H, B]].unwrap(a.head)
    }

  }

  implicit def caseClassParser[A, R <: HList, B](implicit
                                                 gen: Generic[A] {type Repr = R},
                                                 reprWrap: Wrap[R, B]
                                                ): Wrap[A, B] = new Wrap[A, B] {
    override def wrap(s: B): A = gen.from(reprWrap.wrap(s))

    override def unwrap(a: A): B = reprWrap.unwrap(gen.to(a))
  }


}
