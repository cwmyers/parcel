package model.smart

case class Phone (number: String)

object Phone {
  def wrap(number:String): Option[Phone] = Some(Phone(number))
}

