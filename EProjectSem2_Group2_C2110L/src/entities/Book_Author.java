package entities;

public class Book_Author {
	private int id;
	private int id_author;
	private String id_book;

//ToString
	@Override
	public String toString() {
		return "Book_Author [id=" + id + ", id_author=" + id_author + ", id_book=" + id_book + "]";
	}

//Get-Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_author() {
		return id_author;
	}

	public void setId_author(int id_author) {
		this.id_author = id_author;
	}

	public String getId_book() {
		return id_book;
	}

	public void setId_book(String id_book) {
		this.id_book = id_book;
	}

//Constructor
	public Book_Author(int id, int id_author, String id_book) {
		super();
		this.id = id;
		this.id_author = id_author;
		this.id_book = id_book;
	}

	public Book_Author() {
		super();
	}

}
