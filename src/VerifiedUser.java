public class VerifiedUser extends UnverifiedUser {
	private boolean isVerified;
	public VerifiedUser (String name) {
		super(name);
		this.isVerified = true;
		this.maxBooks = 4;
	}

	public boolean isVerified() {
		return this.isVerified;
	}

	public void reserveBook(Library library, String title) {
		Book book = library.searchBookByTitle(title);

		if(book == null) {
			System.out.println("Book with the title " + title + " was not found.");
			return;
		}

		book.setReservedFor(this);
		System.out.println(this.getName() + " reserved '" + title + "'.");
	}
}
