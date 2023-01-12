package entities;

import java.util.Arrays;
import java.util.Date;

public class Book {

	private String callNumber;
	private String ISBN;
	private String title;
	private int quantity;
	private double price;
	private String description;
	private boolean status;
	private byte[] photo;
	private String author;
	private String category;
	private Date created;

//	ToString
	@Override
	public String toString() {
		return "Book [callNumber=" + callNumber + ", ISBN=" + ISBN + ", title=" + title + ", quantity=" + quantity
				+ ", price=" + price + ", description=" + description + ", status=" + status + ", photo="
				+ Arrays.toString(photo) + ", author=" + author + ", category=" + category + ", created=" + created
				+ "]";
	}

//	Constructor
	public Book(String callNumber, String iSBN, String title, int quantity, double price, String description,
			boolean status, byte[] photo, String author, String category, Date created) {
		super();
		this.callNumber = callNumber;
		ISBN = iSBN;
		this.title = title;
		this.quantity = quantity;
		this.price = price;
		this.description = description;
		this.status = status;
		this.photo = photo;
		this.author = author;
		this.category = category;
		this.created = created;
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

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
