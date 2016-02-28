package model.smart

case class Phone private(number: String) extends AnyVal

object Phone {
  def wrap(number:String): Option[Phone] = None //Some(Phone(number))
}

