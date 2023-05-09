public class Book {
	private String title;
	private String author;
	private boolean availability;
	private String reservedFor;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.availability = true;
		this.reservedFor = null;
	}

	public String getTitle() {
		return this.title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setReservedFor(VerifiedUser user) {
		if(user.isVerified()) {
			this.reservedFor = user.getName();
		}
	}

	public String getReservedFor() {
		return this.reservedFor;
	}

	public boolean getAvailability() {
		return this.availability && this.reservedFor == null;
	}

	public void setAvailibility(boolean availability) {
		this.availability = availability;
	}
}
