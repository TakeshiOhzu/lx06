package lx06

import org.scalatest._
import AddressBook._

class Test extends FlatSpec with Matchers {

  "住所録の初期状態" should "be 空" in {
    address_book should be (List())
  }

  "空の住所録にAdamを追加したら" should "contain Adam" in {
    address_book = List()
    add_to_address_book('Adam, "014-1421-356")

    address_book match {
      case (name, phone) :: _ => {
        name == 'Adam should be (true)
        phone should be ("014-1421-356")
      }
      case _ => fail("こういうことはあってはいけない")
    }
  }

  "Eveが登録されている住所録にAdamを追加したら" should "contain Adam" in {
    address_book = List()
    add_to_address_book('Eve,  "017-3205-08")
    add_to_address_book('Adam, "014-1421-356")

    address_book should be (List(('Adam, "014-1421-356"), ('Eve, "017-3205-08")))
  }
}
