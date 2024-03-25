package cz.fel.cvut.ass;

public class Book  extends Thing {
	private String isbn;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	Book(){}
	@Override
	public Thing clone() {
		Book b = (Book) super.clone();
		b.setIsbn(isbn);
		return b;
	}
}
