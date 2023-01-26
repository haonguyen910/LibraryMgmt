package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Employee;

public class EmployeeModel {
//One
	public boolean create(Employee employee) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"insert into employee(id, name, address, phone, department, username, password, created, is_admin, photo) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getAddress());
			ps.setString(4, employee.getPhone());
			ps.setString(5, employee.getDepartment());
			ps.setString(6, employee.getUsername());
			ps.setString(7, employee.getPassword());
			ps.setDate(8, new java.sql.Date(employee.getCreated().getTime()));
			ps.setBoolean(9, employee.isIs_admin());
			ps.setBytes(10, employee.getPhoto());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(Employee employee) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"update employee set name = ?, address = ?, phone = ?, department = ?, username = ?, password = ?, is_admin = ?, photo = ? where id = ?");
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getAddress());
			ps.setString(3, employee.getPhone());
			ps.setString(4, employee.getDepartment());
			ps.setString(5, employee.getUsername());
			ps.setString(6, employee.getPassword());
			ps.setBoolean(7, employee.isIs_admin());
			ps.setBytes(8, employee.getPhoto());
			ps.setInt(9, employee.getId());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}
	
	public boolean delete(int id) {
		boolean result = true;
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement(
					"delete from employee where id = ?");
			ps.setInt(1, id);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}


	public Employee find(int id) {
		Employee employee = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM employee WHERE id = ?");

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setCreated(resultSet.getDate("created"));
				employee.setIs_admin(resultSet.getBoolean("is_admin"));
				employee.setPhoto(resultSet.getBytes("photo"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			employee = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employee;
	}

//List
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement ps = ConnectDB.connection().prepareStatement("select * from employee");
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setCreated(resultSet.getDate("created"));
				employee.setIs_admin(resultSet.getBoolean("is_admin"));
				employee.setPhoto(resultSet.getBytes("photo"));
				employees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
			employees = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employees;
	}

	public List<Employee> findById(int id) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM employee WHERE id = ?");
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setCreated(resultSet.getDate("created"));
				employee.setIs_admin(resultSet.getBoolean("is_admin"));
				employee.setPhoto(resultSet.getBytes("photo"));
				employees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
			employees = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employees;
	}

	public List<Employee> findByName(String name) {
		List<Employee> employees = new ArrayList<Employee>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM employee WHERE name LIKE ?");
			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setAddress(resultSet.getString("address"));
				employee.setPhone(resultSet.getString("phone"));
				employee.setDepartment(resultSet.getString("department"));
				employee.setUsername(resultSet.getString("username"));
				employee.setPassword(resultSet.getString("password"));
				employee.setCreated(resultSet.getDate("created"));
				employee.setIs_admin(resultSet.getBoolean("is_admin"));
				employee.setPhoto(resultSet.getBytes("photo"));
				employees.add(employee);
			}

		} catch (Exception e) {
			e.printStackTrace();
			employees = null;
		} finally {
			ConnectDB.disconnect();
		}
		return employees;
	}

}
