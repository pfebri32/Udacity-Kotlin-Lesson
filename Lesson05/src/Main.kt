import Book.Book

fun main() {
    // 3. Practice Time
    // Pairs
    val book = Book("Harry Potter", "J. K. Rowling", 1997)

    /*val (author, title) = book.getTitleAndAuthor()*/
    val (author, title, year) = book.getTitleAuthorAndYear()
    println(author)
    println(title)
    println(year)
}