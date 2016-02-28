package model

import parcel.OptionWrap

package object smart {

  implicit val smartPhoneWrap: OptionWrap[Phone, String] = new OptionWrap[Phone, String] {
    override def wrap(b: String): Option[Phone] = Phone wrap b
  }

}
