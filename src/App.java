import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Bible", "God"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book("Pride and Prejudice", "Jane Austen"));
        books.add(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        Library library = new Library(books);


        LibraryUser polar = new UnverifiedUser("Polar");
        LibraryUser hopper = new VerifiedUser("Hopper");
        
        polar.borrowBook(library, "Bible"); // Polar borrowed 'Bible'.
        polar.borrowBook(library, "The Great Gatsby"); // Polar cannot check out any more books.

        polar.listBooks();
        /*
-----

Borrowed Books List for Polar

Title: Bible
Author: God


-----
  */

        hopper.borrowBook(library, "1984"); // Hopper borrowed '1984'.
        hopper.borrowBook(library, "To Kill a Mockingbird"); // Hopper borrowed 'To Kill a Mockingbird'.
        hopper.reserveBook(library, "Bible"); // Hopper reserved 'Bible'.

        hopper.listBooks(); /*
        Borrowed Books List for Hopper
        
        Title: 1984
        Author: George Orwell
        
        
        Title: To Kill a Mockingbird
        Author: Harper Lee
        
        */

        polar.returnBook(library, "Bible"); // Polar returned 'Bible'.
        polar.borrowBook(library, "Bible"); // Polar could not borrow 'Bible'.
    }
}
