import model.smart.Phone
import org.specs2.mutable.Specification
import parcel.SmartStringParcel
import parcel.smart._
import model.smart.smartPhoneWrap

object SmartModelSpec extends Specification{

  "SmartParcel" should {
    "derive typeclass" in {
      val smartParcel: SmartStringParcel[Phone] = implicitly[SmartStringParcel[Phone]]
      "wrap" in {
        smartParcel.wrap("234") must beSome(Phone("234"))
//        true === true
      }
    }

  }
}
