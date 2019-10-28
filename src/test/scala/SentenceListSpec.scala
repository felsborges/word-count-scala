import org.scalatest._
import wordCount.SentenceList

class SentenceListSpec extends FunSuite with DiagrammedAssertions {
    /*test("Deve retornar 'get'") {
        assert(SentenceList.get(1) == "get")
    }*/

    test("Dado um inteiro Deve retornar uma sentença") {
        assert(SentenceList.get(1) == "apples")
    }
}