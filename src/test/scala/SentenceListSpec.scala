import org.scalatest._
import wordCount.SentenceList

class SentenceListSpec extends FunSuite with DiagrammedAssertions {
    val modeloTeste = """[{"id": 0, "language": "pt", "text": "O dinheiro faz homens ricos, o conhecimento faz homens sábios e a humildade faz grandes homens."},
                          {"id": 1, "language": "pt", "text": "Bons amigos são como estrelas: nem sempre podemos ver, mas temos certeza que estão sempre lá."},
                          {"id": 2, "language": "pt", "text": "Viva simples, sonhe grande, seja grato, dê amor, ria muito!"},
                          {"id": 3, "language": "pt", "text": "Se for pra desistir, desista de ser fraco."}]"""

    /*Get*/
    test("Dado um inteiro Deve retornar uma sentença") {
        
        val sentence = new SentenceList(modeloTeste)
        assert(sentence.get(0) == "O dinheiro faz homens ricos, o conhecimento faz homens sábios e a humildade faz grandes homens.")    
    }

    test("Dado um inteiro maior que 0 Deve retornar uma sentença") {
        
        val sentence = new SentenceList(modeloTeste)
        assert(sentence.get(1) == "Bons amigos são como estrelas: nem sempre podemos ver, mas temos certeza que estão sempre lá.")    
    }

    test("Dado um dicionario Deve retornar a lista de palavras das sentenças") {
        val sentence = new SentenceList(modeloTeste)
        assert(sentence.sentences() == List(List("O", "dinheiro", "faz", "homens", "ricos", "o", "conhecimento", "faz", "homens", "s├íbios", "e", "a", "humildade", "faz", "grandes", "homens"), List("Bons", "amigos", "s├úo", "como", "estrelas", "nem", "sempre", "podemos", "ver", "mas", "temos", "certeza", "que", "est├úo", "sempre", "l├í"), List("Viva", "simples", "sonhe", "grande", "seja", "grato", "d├¬", "amor", "ria", "muito"), List("Se", "for", "pra", "desistir", "desista", "de", "ser", "fraco")))
    }

}