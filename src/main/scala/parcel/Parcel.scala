package parcel

trait Parcel[A, B] extends Wrap[A,B] with Unwrap[A,B]
