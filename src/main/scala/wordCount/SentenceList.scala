package wordCount
import play.api.libs.json._

object Main {
    def main(args: Array[String]) {

        val modeloTeste = """[{"id": 0, "language": "pt", "text": "O dinheiro faz homens ricos, o conhecimento faz homens sábios e a humildade faz grandes homens."},
                              {"id": 1, "language": "pt", "text": "Bons amigos são como estrelas: nem sempre podemos ver, mas temos certeza que estão sempre lá."},
                              {"id": 2, "language": "pt", "text": "Viva simples, sonhe grande, seja grato, dê amor, ria muito!"},
                              {"id": 3, "language": "pt", "text": "Se for pra desistir, desista de ser fraco."}]"""

        val sentence = new SentenceList(modeloTeste)
    }
}

class SentenceList (doc:String) {
    private val docList = doc

    //Lista de listas de palavras
    def sentences() = {
        val listTest = this.docList
        val parsed = Json.parse(listTest)
        val parsedList = (parsed \\ "text").toList
        parsedList.map(x => x.toString.replaceAll("[,.?!\":]", "").split(" ").toList)
    }
    
    //e-nesima sentença
    def get(n: Int) : String = {
        val listTest = this.docList
        val parsed = Json.parse(listTest)
        (parsed \ n \ "text").as[String]
    }

    //número total de ocorrências de W
    def freq(w: String) = {
        var frequencia = 0
        
        this.sentences.map(x => x.map(y => if (y == w) frequencia = frequencia + 1))

        frequencia
    }
    //número de ocorrências de w na sentença
    def freq(w: String, s: Int) = {
        var frequencia = 0

        val sent = this.sentences

        sent(s).map(y => if (y == w) frequencia = frequencia + 1)

        frequencia
    }

    //Lista de plavra de um sentença
    def sentences(s: Int) : List[String] = {
        val sent = this.sentences
        sent(s)
    }
}



