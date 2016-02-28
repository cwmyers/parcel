package parcel

import shapeless.{Generic, ::, HList, HNil}

import cats.Monoid

trait ParcelInstances {

  implicit val stringParcel: StringParcel[String] = new StringParcel[String] {
    override def wrap(a: String): String = a

    override def unwrap(a: String): String = a
  }

  implicit val intParcel: IntParcel[Int] = new IntParcel[Int] {
    override def wrap(b: Int): Int = b

    override def unwrap(a: Int): Int = a
  }

  implicit val longParcel: LongParcel[Long] = new LongParcel[Long] {
    override def wrap(b: Long): Long = b

    override def unwrap(a: Long): Long = a
  }

  implicit val doubleParcel: DoubleParcel[Double] = new DoubleParcel[Double] {
    override def wrap(b: Double): Double = b

    override def unwrap(a: Double): Double = a
  }

  implicit val floatParcel: FloatParcel[Float] = new FloatParcel[Float] {
    override def wrap(b: Float): Float = b

    override def unwrap(a: Float): Float = a
  }

  implicit val byteParcel: ByteParcel[Byte] = new ByteParcel[Byte] {
    override def wrap(b: Byte): Byte = b

    override def unwrap(a: Byte): Byte = a
  }

  implicit val booleanParcel: BooleanParcel[Boolean] = new BooleanParcel[Boolean] {
    override def wrap(b: Boolean): Boolean = b

    override def unwrap(a: Boolean): Boolean = a
  }


  implicit def hnilParcel[B: Monoid]: Parcel[HNil, B] = new Parcel[HNil, B] {
    override def wrap(s: B): HNil = HNil

    override def unwrap(a: HNil): B = implicitly[Monoid[B]].empty
  }

  implicit def hconsParcel[H, T <: HList, B](implicit wrap1: Parcel[H, B], wrap2: Parcel[T, B]): Parcel[H :: T, B] = new Parcel[H :: T, B] {
    override def wrap(b: B): ::[H, T] = {
      val hParcel: Parcel[H, B] = wrap1
      val tParcel: Parcel[T, B] = wrap2
      hParcel.wrap(b) :: tParcel.wrap(b)
    }

    override def unwrap(a: ::[H, T]): B = {
      implicitly[Parcel[H, B]].unwrap(a.head)
    }

  }

  implicit def caseClassParser[A, R <: HList, B](implicit
                                                 gen: Generic[A] {type Repr = R},
                                                 reprParcel: Parcel[R, B]
                                                ): Parcel[A, B] = new Parcel[A, B] {
    override def wrap(s: B): A = gen.from(reprParcel.wrap(s))

    override def unwrap(a: A): B = reprParcel.unwrap(gen.to(a))
  }


}
