package wordCount

object SentenceList {
    def main(args: Array[String]) {
      
        SentenceList.sentences
        //SentenceList.get(1)
        SentenceList.freq("Texto 1")
        SentenceList.freq("Texto 2", 1)
    }
    //Lista de listas de palavras
    def sentences() = println("sentences")
    //e-nesima sentença
    def get(n: Int) : String = {
        var listTest = List("lemon", "apples", "oranges", "bananas")
        listTest(n)
        }
    //número total de ocorrências de W
    def freq(w: String) = println("freq (1)")
    //número de ocorrências de w na sentença
    def freq(w: String, s: Int) = println("freq (2)")
}
