
package object parcel {
  type StringParcel[A] = Parcel[A, String]
  type IntParcel[A] = Parcel[A, Int]
  type LongParcel[A] = Parcel[A, Long]
  type DoubleParcel[A] = Parcel[A, Double]
  type FloatParcel[A] = Parcel[A, Float]
  type ByteParcel[A] = Parcel[A, Byte]
  type BooleanParcel[A] = Parcel[A, Boolean]

  type SmartStringParcel[A] = SmartParcel[A, String]
  type SmartIntParcel[A] = SmartParcel[A, Int]
  type SmartLongParcel[A] = SmartParcel[A, Long]
  type SmartDoubleParcel[A] = SmartParcel[A, Double]
  type SmartFloatParcel[A] = SmartParcel[A, Float]
  type SmartByteParcel[A] = SmartParcel[A, Byte]
  type SmartBooleanParcel[A] = SmartParcel[A, Boolean]

  object simple extends DefaultMonoidInstances with ParcelInstances
  object smart extends DefaultMonoidInstances with SmartParcelInstances
}
