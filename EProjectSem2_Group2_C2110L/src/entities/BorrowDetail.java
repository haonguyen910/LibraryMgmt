package entities;

import java.util.List;

public class BorrowDetail {
	private int id;
	private int id_borrow;
	private String id_book;
	public int quantity;
	private double price;

//	ToString
	@Override
	public String toString() {
		return "BorrowDetail [id=" + id + ", id_borrow=" + id_borrow + ", id_book=" + id_book + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

//	Constructor
	public BorrowDetail(int id, int id_borrow, String id_book, int quantity, double price) {
		super();
		this.id = id;
		this.id_borrow = id_borrow;
		this.id_book = id_book;
		this.quantity = quantity;
		this.price = price;
	}

	public BorrowDetail() {
		super();
	}

//	Get-Set
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_borrow() {
		return id_borrow;
	}

	public void setId_borrow(int id_borrow) {
		this.id_borrow = id_borrow;
	}

	public String getId_book() {
		return id_book;
	}

	public void setId_book(String id_book) {
		this.id_book = id_book;
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

}
