package wordCount
import play.api.libs.json._

object Main {
    def main(args: Array[String]) {
        val modeloTeste = """[{"id": 0, "language": "pt", "text": "O dinheiro faz homens ricos, o conhecimento faz homens sábios e a humildade faz grandes homens."},
                          {"id": 1, "language": "pt", "text": "Bons amigos são como estrelas: nem sempre podemos ver, mas temos certeza que estão sempre lá."},
                          {"id": 2, "language": "pt", "text": "Viva simples, sonhe grande, seja grato, dê amor, ria muito!"},
                          {"id": 3, "language": "pt", "text": "Se for pra desistir, desista de ser fraco."}]"""

        val sentence = new SentenceList(modeloTeste)

        sentence.sentences
        //SentenceList.get(1)
        sentence.freq("Texto 1")
        sentence.freq("Texto 2", 1)
    }
}

class SentenceList (doc:String) {
    val docList = doc

    //Lista de listas de palavras
    def sentences() = {
        val listTest = this.docList
        val parsed = Json.parse(listTest)
        val parsedList = (parsed \\ "text").toList
        //val parsedListNew = parsedList.map(x => x.toString.split("\\s+").map(_.trim).toList)
        val parsedListNew = parsedList.map(x => x.toString.replaceAll("\\P{L}", " ").trim.split("\\s+").toList)
        val clearList = parsedListNew
        println(clearList)
    }
    
    //e-nesima sentença
    def get(n: Int) : String = {
        val listTest = this.docList
        val parsed = Json.parse(listTest)
        (parsed \ n \ "text").as[String]
        }
    //número total de ocorrências de W
    def freq(w: String) = println("freq (1)")
    //número de ocorrências de w na sentença
    def freq(w: String, s: Int) = println("freq (2)")

}



