package model

package object simple {
  case class StreetName(name: String) extends AnyVal
  case class StreetNumber(number:String) extends AnyVal
  case class Suburb(suburb: String) extends AnyVal
  case class PostCode(postCode: String) extends AnyVal
  case class Price(price: Int) extends AnyVal
  case class Address(streetNumber: StreetNumber, streetName: StreetName, postCode: PostCode, suburb: Suburb)

}
