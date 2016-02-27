package parcel

trait Wrap[A, B] {
  def wrap(b: B): A
}
