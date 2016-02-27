
package object parcel {
  type StringParcel[A] = Parcel[A, String]
  type IntParcel[A] = Parcel[A, Int]
  type LongParcel[A] = Parcel[A, Long]
  type DoubleParcel[A] = Parcel[A, Double]
  type FloatParcel[A] = Parcel[A, Float]
  type ByteParcel[A] = Parcel[A, Byte]
  type BooleanParcel[A] = Parcel[A, Boolean]

  object auto extends ParcelInstances
}
