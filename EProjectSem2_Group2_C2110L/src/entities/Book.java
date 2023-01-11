package entities;

public class Book {

	private String callNumber;
	private String ISBN;
	private String title;
	private int quantity;
	private double price;
	private String photo;
	private String description;
	private boolean status;
	private String author;
	private String category;

//	Constructor
	public Book(String callNumber, String iSBN, String title, int quantity, double price, String photo,
			String description, boolean status, String author, String category) {
		super();
		this.callNumber = callNumber;
		ISBN = iSBN;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.photo = photo;
		this.description = description;
		this.status = status;
		this.author = author;
		this.category = category;
	}

	public Book() {
		super();
	}

//	Get-Set
	public String getCallNumber() {
		return callNumber;
	}

	public void setCallNumber(String callNumber) {
		this.callNumber = callNumber;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
