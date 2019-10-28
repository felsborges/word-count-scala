package wordCount
import play.api.libs.json._

object Main {
    def main(args: Array[String]) {
        val sentence = new SentenceList("""[{"id": 0, "language": "pt", "text": "apples"}]""")

        sentence.sentences
        //SentenceList.get(1)
        sentence.freq("Texto 1")
        sentence.freq("Texto 2", 1)
    }
}

class SentenceList (doc:String) {
    val docList = doc

     //Lista de listas de palavras
    def sentences() = println("sentences")
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


