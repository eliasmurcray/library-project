import java.util.ArrayList;

public class UnverifiedUser implements LibraryUser {
	private String name;
	private ArrayList<Book> borrowedBooks;
	protected int maxBooks;

	public UnverifiedUser(String name) {
		this.name = name;
		this.borrowedBooks = new ArrayList<>();
		this.maxBooks = 1;
	}

	@Override
	public void reserveBook(Library library, String title) {
		System.out.println(this.name + " does not have reservation privileges");
	}

	public String getName() {
		return this.name;
	}

	public void listBooks() {
		System.out.println("\n-----\n\nBorrowed Books List for " + this.name + '\n');
		this.borrowedBooks.forEach(book -> {
			System.out.println("Title: " + book.getTitle());
			System.out.println("Author: " + book.getAuthor());
			System.out.println('\n');
		});
		System.out.println("-----\n");
	}

	public Book searchBookByTitle(String title) {
		for(Book book : this.borrowedBooks) {
			if(book.getTitle() == title) {
				return book;
			} 
		}
		return null;
	}

	public Book searchBookByAuthor(String author) {
		for(Book book : this.borrowedBooks) {
			if(book.getAuthor() == author) {
				return book;
			} 
		}
		return null;
	}

	public void borrowBook(Library library, String title) {
		if(this.borrowedBooks.size() >= this.maxBooks) {
			System.out.println(this.name + " cannot check out any more books.");
			return;
		}

		Book book = library.searchBookByTitle(title);

		if(book == null) {
			System.out.println("Book with title " + title + " does not exists.");
			return;
		}

		if(library.checkoutBook(book)) {
			this.borrowedBooks.add(book);
			System.out.println(this.name + " borrowed '" + title + "'.");
		} else {
			System.out.println(this.name + " could not borrow '" + title + "'.");
		}
	}

	public void returnBook(Library library, String title) {
		Book book = this.searchBookByTitle(title);

		if(book == null) {
			System.out.println("'" + title + "' does not exist.");
			return;
		}

		library.returnBook(book);
		this.borrowedBooks.remove(book);
		System.out.println(this.name + " returned '" + title + "'.");
	}
}


