public interface LibraryUser {
	String getName();
	void listBooks();
	Book searchBookByTitle(String title);
	Book searchBookByAuthor(String author);
	void borrowBook(Library library, String title);
	void returnBook(Library library, String title);
	void reserveBook(Library library, String title);
}
