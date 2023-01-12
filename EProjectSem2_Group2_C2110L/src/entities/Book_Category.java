package entities;

public class Book_Category {
	private int id;
	private int id_category;
	private String id_book;

//ToString
	@Override
	public String toString() {
		return "Book_Category [id=" + id + ", id_category=" + id_category + ", id_book=" + id_book + "]";
	}

//Constructor
	public Book_Category(int id, int id_category, String id_book) {
		super();
		this.id = id;
		this.id_category = id_category;
		this.id_book = id_book;
	}

	public Book_Category() {
		super();
	}

//Get-Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_category() {
		return id_category;
	}

	public void setId_category(int id_category) {
		this.id_category = id_category;
	}

	public String getId_book() {
		return id_book;
	}

	public void setId_book(String id_book) {
		this.id_book = id_book;
	}

}
