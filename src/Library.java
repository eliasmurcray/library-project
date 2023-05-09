import java.util.ArrayList;
import java.util.Iterator;

public class Library {
	private ArrayList<Book> books;

	public Library(ArrayList<Book> books) {
		this.books = books;
	}

	public void addBook(Book book) {
		this.books.add(book);
	}

	public void listBooks() {
		System.out.println("Book List");
		this.books.forEach(book -> {
			System.out.println("Title: " + book.getTitle());
			System.out.println("Author: " + book.getAuthor());
			System.out.println("Availability" + book.getAvailability());
			System.out.println("-----");
		});
	}

	public Book searchBookByTitle(String title) {
		for(Book book : this.books) {
			if(book.getTitle() == title) {
				return book;
			}
		}
		return null;
	}

	public Book searchBookByAuthor(String author) {
		Iterator<Book> iterator = this.books.iterator();
		while(iterator.hasNext()) {
			Book book = iterator.next();
			if(book.getAuthor() == author) {
				return book;
			}
		}
		return null;
	}

	public boolean checkoutBook(Book book) {
		for(Book _book : this.books) {
			if(_book.getAuthor() == book.getAuthor() && _book.getTitle() == book.getTitle() && _book.getAvailability() == true) {
				_book.setAvailibility(false);
				return true;
			}
		}
		return false;
	}

	public void returnBook(Book book) {
		Iterator<Book> iterator = this.books.iterator();
		while(iterator.hasNext()) {
			Book _book = iterator.next();
			if(_book.getAuthor() == book.getAuthor() && _book.getTitle() == book.getTitle() && _book.getAvailability() == true) {
				_book.setAvailibility(true);
				return;
			}
		}
	}
}
