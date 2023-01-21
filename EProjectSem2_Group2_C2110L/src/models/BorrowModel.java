package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Borrow;

public class BorrowModel {
//	One
	public boolean create(Borrow borrow) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"INSERT INTO borrow(id_customer, id_employee, created, due_date, deposit) values(?,?,CURDATE(),TIMESTAMPADD(DAY,5,CURDATE()),?)");

			preparedStatement.setInt(1, borrow.getId_customer());
			preparedStatement.setInt(2, borrow.getId_employee());
			preparedStatement.setDouble(3, borrow.getDeposit());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(Borrow borrow) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE borrow SET id_customer = ?, id_employee = ?, deposit = ? WHERE id = ?");

			preparedStatement.setInt(1, borrow.getId_customer());
			preparedStatement.setInt(2, borrow.getId_employee());
			preparedStatement.setDouble(3, borrow.getDeposit());
			preparedStatement.setInt(4, borrow.getId());

			result = preparedStatement.executeUpdate() > 0;
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
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("DELETE FROM borrow WHERE id = ?");

			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	// List
	public List<Borrow> findAll() {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrow.*, customer.name AS customerName, employee.name AS employeeName\r\n"
							+ "FROM borrow LEFT JOIN customer ON borrow.id_customer = customer.id\r\n"
							+ "LEFT JOIN employee ON borrow.id_employee = employee.id");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(resultSet.getInt("id"));
				borrow.setCreated(resultSet.getDate("created"));
				borrow.setDue_date(resultSet.getDate("due_date"));
				borrow.setId_customer(resultSet.getInt("id_customer"));
				borrow.setId_employee(resultSet.getInt("id_employee"));
				borrow.setDeposit(resultSet.getDouble("deposit"));
				borrow.setEmployeeName(resultSet.getString("employeeName"));
				borrow.setCustomerName(resultSet.getString("customerName"));

				borrowList.add(borrow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowList;
	}

	public List<Borrow> findById(int id) {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrow.*, customer.name AS customerName, employee.name AS employeeName\r\n"
							+ "FROM borrow LEFT JOIN customer ON borrow.id_customer = customer.id\r\n"
							+ "LEFT JOIN employee ON borrow.id_employee = employee.id\r\n" + "WHERE borrow.id = ?");

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(resultSet.getInt("id"));
				borrow.setCreated(resultSet.getDate("created"));
				borrow.setDue_date(resultSet.getDate("due_date"));
				borrow.setId_customer(resultSet.getInt("id_customer"));
				borrow.setId_employee(resultSet.getInt("id_employee"));
				borrow.setDeposit(resultSet.getDouble("deposit"));
				borrow.setEmployeeName(resultSet.getString("employeeName"));
				borrow.setCustomerName(resultSet.getString("customerName"));

				borrowList.add(borrow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowList;
	}

	public List<Borrow> findByEmployeeName(String employeeName) {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrow.*, customer.name AS customerName, employee.name AS employeeName\r\n"
							+ "FROM borrow LEFT JOIN customer ON borrow.id_customer = customer.id\r\n"
							+ "LEFT JOIN employee ON borrow.id_employee = employee.id\r\n"
							+ "WHERE employee.name LIKE ?");

			preparedStatement.setString(1, "%" + employeeName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(resultSet.getInt("id"));
				borrow.setCreated(resultSet.getDate("created"));
				borrow.setDue_date(resultSet.getDate("due_date"));
				borrow.setId_customer(resultSet.getInt("id_customer"));
				borrow.setId_employee(resultSet.getInt("id_employee"));
				borrow.setDeposit(resultSet.getDouble("deposit"));
				borrow.setEmployeeName(resultSet.getString("employeeName"));
				borrow.setCustomerName(resultSet.getString("customerName"));

				borrowList.add(borrow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowList;
	}

	public List<Borrow> findByCustomerName(String customerName) {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrow.*, customer.name AS customerName, employee.name AS employeeName\r\n"
							+ "FROM borrow LEFT JOIN customer ON borrow.id_customer = customer.id\r\n"
							+ "LEFT JOIN employee ON borrow.id_employee = employee.id\r\n"
							+ "WHERE customer.name LIKE ?");

			preparedStatement.setString(1, "%" + customerName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(resultSet.getInt("id"));
				borrow.setCreated(resultSet.getDate("created"));
				borrow.setDue_date(resultSet.getDate("due_date"));
				borrow.setId_customer(resultSet.getInt("id_customer"));
				borrow.setId_employee(resultSet.getInt("id_employee"));
				borrow.setDeposit(resultSet.getDouble("deposit"));
				borrow.setEmployeeName(resultSet.getString("employeeName"));
				borrow.setCustomerName(resultSet.getString("customerName"));

				borrowList.add(borrow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowList;
	}

	public List<Borrow> findByCreated(Date created) {
		List<Borrow> borrowList = new ArrayList<Borrow>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrow.*, customer.name AS customerName, employee.name AS employeeName\r\n"
							+ "FROM borrow LEFT JOIN customer ON borrow.id_customer = customer.id\r\n"
							+ "LEFT JOIN employee ON borrow.id_employee = employee.id\r\n"
							+ "WHERE borrow.created = ?");

			preparedStatement.setDate(1, new java.sql.Date(created.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(resultSet.getInt("id"));
				borrow.setCreated(resultSet.getDate("created"));
				borrow.setDue_date(resultSet.getDate("due_date"));
				borrow.setId_customer(resultSet.getInt("id_customer"));
				borrow.setId_employee(resultSet.getInt("id_employee"));
				borrow.setDeposit(resultSet.getDouble("deposit"));
				borrow.setEmployeeName(resultSet.getString("employeeName"));
				borrow.setCustomerName(resultSet.getString("customerName"));

				borrowList.add(borrow);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowList;
	}
}
