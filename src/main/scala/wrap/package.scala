
package object wrap {
  type WrapString[A] = Wrap[A, String]
  type WrapInt[A] = Wrap[A, Int]
  type WrapLong[A] = Wrap[A, Long]
  type WrapDouble[A] = Wrap[A, Double]
  type WrapFloat[A] = Wrap[A, Float]
  type WrapByte[A] = Wrap[A, Byte]
  type WrapBoolean[A] = Wrap[A, Boolean]

  object auto extends WrapInstances
}
