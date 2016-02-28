package parcel

import cats._
import cats.syntax.all._
import cats.std.all._
import shapeless._

trait SmartParcelInstances {

  implicit def smartStringParcel: SmartStringParcel[String] = new SmartStringParcel[String] {
    override def unwrap(a: String): String = a

    override def wrap(b: String): Option[String] = Some(b)
  }

  implicit def hnilSmartParcel[B: Monoid]: SmartParcel[HNil, B] = new SmartParcel[HNil, B] {

    override def unwrap(a: HNil): B = implicitly[Monoid[B]].empty

    override def wrap(b: B): Option[HNil] = Some(HNil)
  }

  implicit def hconsSmartParcel[H, T <: HList, B](implicit hWrap: SmartParcel[H, B],
                                                  tWrap: SmartParcel[T, B]): SmartParcel[H :: T, B] = new SmartParcel[H :: T, B] {
    override def wrap(b: B): Option[H :: T] = {
      hWrap.wrap(b).map2(tWrap.wrap(b))(_ :: _)
    }

    override def unwrap(a: ::[H, T]): B = {
      hWrap.unwrap(a.head)
    }

  }

  implicit def caseClassParser[A, R <: HList, B](implicit
                                                 gen: Generic[A] {type Repr = R},
                                                 reprParcel: SmartParcel[R, B],
                                                 oWrap: OptionWrap[A, B]
                                                ): SmartParcel[A, B] = new SmartParcel[A, B] {
    override def wrap(s: B): Option[A] = {
      oWrap.wrap(s)
    }

    override def unwrap(a: A): B = reprParcel.unwrap(gen.to(a))
  }

}
