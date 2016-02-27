package parcel

trait Unwrap[A, B] {
  def unwrap(a: A): B
}
