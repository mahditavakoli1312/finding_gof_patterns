package cz.cvut.fel;

public class Book {
	private String ISBN;
	private Author author;
	private int pages;
	private double rating;
	
	public Book(String ISBN, Author author, int pages, double rating) {
		super();
		this.ISBN = ISBN;
		this.author = author;
		this.pages = pages;
		this.rating = rating;
	}

	public Book() {
		super();
	}

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}

}
