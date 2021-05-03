package Book

open class Book(
    val title: String,
    val author: String,
) {
    private var currPage = 0
    open fun readPage() { currPage++ }
}

class EBook(
    title: String,
    author: String,
    val format: String = "text",
) : Book(title, author) {
    private var wordsRead = 0;
    override fun readPage() { wordsRead += 250 }
}