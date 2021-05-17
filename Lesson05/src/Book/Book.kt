package Book

class Book(
    val title: String,
    val author: String,
    val year: Int,
) {
    fun getTitleAndAuthor() = (title to author)
    fun getTitleAuthorAndYear() = Triple(title, author, year)
}