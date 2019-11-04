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

        assert(sentence.sentences() == List(List("O", "dinheiro", "faz", "homens", "ricos", "o", "conhecimento", "faz", "homens", "sábios", "e", "a", "humildade", "faz", "grandes", "homens"),
                                            List("Bons", "amigos", "são", "como", "estrelas", "nem", "sempre", "podemos", "ver", "mas", "temos", "certeza", "que", "estão", "sempre", "lá"),
                                            List("Viva", "simples", "sonhe", "grande", "seja", "grato", "dê", "amor", "ria", "muito"),
                                            List("Se", "for", "pra", "desistir", "desista", "de", "ser", "fraco")))
    }

    test("Dado uma palavra buscar a frequência que está aparece em um determinado dicionário") {

        val sentence = new SentenceList(modeloTeste)
        val w = "homens"
        assert(sentence.freq(w) == 3)
    }

    test("Dado uma palavra e o número de uma sentença deve retornar a frequencia da palavra na sentença") {

        val sentence = new SentenceList(modeloTeste)

        val w = "homens"
        val s = 0

        assert(sentence.freq(w, s) == 3)
    }

    test("Dado o número de uma sentença deve retornar uma lista de palavras") {
        val s = 3

        val sentence = new SentenceList(modeloTeste)

        assert(sentence.sentences(s) == List("Se", "for", "pra", "desistir", "desista", "de", "ser", "fraco"))

    }

}