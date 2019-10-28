import org.scalatest._
import wordCount.SentenceList

class SentenceListSpec extends FunSuite with DiagrammedAssertions {
    /*test("Deve retornar 'get'") {
        assert(SentenceList.get(1) == "get")
    }*/

    test("Dado um inteiro Deve retornar uma sentença") {
        
        val sentence = new SentenceList("""[{"id": 0, "language": "pt", "text": "apples"}]""")
        assert(sentence.get(0) == "apples")    
    }

    test("Dado um inteiro maior que 0 Deve retornar uma sentença") {
        
        val sentence = new SentenceList("""[{"id": 0, "language": "pt", "text": "apples"},{"id": 1, "language": "pt", "text": "banana"}]""")
        assert(sentence.get(1) == "banana")    
    }
}