package parcel

trait SmartWrap[A,B] {
  def wrap(b:B): Option[A]
}
