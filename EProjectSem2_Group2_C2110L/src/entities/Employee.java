package entities;

import java.util.Arrays;
import java.util.Date;

public class Employee {

	private int id;
	private String name;
	private String address;
	private String phone;
	private String email;
	private String username;
	private String password;
	private Date created;
	private boolean is_admin;
	private byte[] photo;

	public Employee() {
		super();
	}

	public Employee(int id, String name, String address, String phone, String email, String username,
			String password, Date created, boolean is_admin, byte[] photo) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
		this.created = created;
		this.is_admin = is_admin;
		this.photo = photo;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public boolean isIs_admin() {
		return is_admin;
	}

	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", department="
				+ email + ", username=" + username + ", password=" + password + ", created=" + created
				+ ", is_admin=" + is_admin + ", photo=" + Arrays.toString(photo) + "]";
	}

}
