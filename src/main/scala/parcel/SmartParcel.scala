package parcel

trait SmartParcel[A,B] extends SmartWrap[A,B] with Unwrap[A,B]
