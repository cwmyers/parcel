package model

import parcel.SmartWrap

package object smart {

  implicit val smartPhoneWrap: SmartWrap[Phone, String] = new SmartWrap[Phone,String] {
    override def wrap(b: String): Option[Phone] = Phone.wrap(b)
  }

}
