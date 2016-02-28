import model.simple.StreetName
import org.specs2.mutable.Specification
import parcel.StringParcel
import parcel.simple._

object SimpleModelSpec extends Specification{

  "Parcel" should {
    "derive typeclass instance" in {
      val parcel = implicitly[StringParcel[StreetName]]

      "wrap" in {
        parcel.wrap("Smith St") === StreetName("Smith St")
      }

      "unwrap" in {
        parcel.unwrap(StreetName("Apple St")) === "Apple St"

      }
    }
  }

}
