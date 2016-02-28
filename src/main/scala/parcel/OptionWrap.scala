package parcel

trait OptionWrap[A, B] {
  def wrap(b: B): Option[A]
}
