package entities;

import java.util.Arrays;
import java.util.Date;

public class Customer {

	private int id;
	private String name;
	private String address;
	private String phone;
	private Date created;

	public Customer() {
		super();
	}

	public Customer(int id, String name, String address, String phone, byte[] photo, Date created) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.created = created;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", photo="
				+ ", created=" + created + "]";
	}

}
