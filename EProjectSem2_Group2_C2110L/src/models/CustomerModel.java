package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Customer;

public class CustomerModel {

	public boolean create(Customer customer) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"insert into customer(id, name, address, phone, created) values(?,?,?,?,?)");
			ps.setInt(1, customer.getId());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getAddress());
			ps.setString(4, customer.getPhone());
			ps.setDate(5, new java.sql.Date(customer.getCreated().getTime()));
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean update(Customer customer) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"update customer set name = ?, address = ?, phone = ? where id = ?");
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getAddress());
			ps.setString(3, customer.getPhone());
			ps.setInt(4, customer.getId());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public List<Customer> findAll(){
		List<Customer> customers = new ArrayList<Customer>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from customer");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Customer customer = new Customer();
				customer.setId(resultSet.getInt("id"));
				customer.setAddress(resultSet.getString("address"));
				customer.setName(resultSet.getString("name"));
				customer.setPhone(resultSet.getString("phone"));
				customer.setCreated(resultSet.getDate("created"));
				customers.add(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			customers = null;
		} finally {
			ConnectDB.disconnect();
		}
		return customers;
	}
}
