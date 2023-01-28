package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Borrow;
import entities.Borrowed;

public class BorrowedModel {
//	One
	public boolean create(Borrowed borrowed) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"INSERT INTO borrowed(id_borrow, created_borrow, due_date_borrow, created, overdue_day, deposit_borrow, fines, total) values(?,?,?,CURDATE(),?,?,?,?)");

			preparedStatement.setInt(1, borrowed.getId_borrow());
			preparedStatement.setDate(2, new java.sql.Date(borrowed.getCreated_borrow().getTime()));
			preparedStatement.setDate(3, new java.sql.Date(borrowed.getDue_date_borrow().getTime()));
			preparedStatement.setInt(4, borrowed.getOverdue_day());
			preparedStatement.setDouble(5, borrowed.getDeposit_borrow());
			preparedStatement.setDouble(6, borrowed.getFines());
			preparedStatement.setDouble(7, borrowed.getTotal());

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
	public List<Borrowed> findAll() {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId\r\n"
							+ "FROM borrowed LEFT JOIN borrow ON borrowed.id_borrow = borrow.id;");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}

	public List<Borrowed> findById(int id) {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId\r\n"
							+ "FROM borrowed LEFT JOIN borrow ON borrowed.id_borrow = borrow.id WHERE borrowed.id = ?");

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}

	public List<Borrowed> findByBorrowId(int idBorrow) {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId\r\n"
							+ "FROM borrowed LEFT JOIN borrow ON borrowed.id_borrow = borrow.id WHERE borrowed.id_borrow = ?");

			preparedStatement.setInt(1, idBorrow);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}

	public List<Borrowed> findByEmployeeName(String employeeName) {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId, employee.name AS employeeName, customer.name AS customerName\r\n"
							+ "FROM borrowed, borrow, employee, customer\r\n"
							+ "WHERE borrowed.id_borrow = borrow.id\r\n" + "AND borrow.id_employee = employee.id\r\n"
							+ "AND borrow.id_customer = customer.id\r\n" + "AND employee.name LIKE ?");

			preparedStatement.setString(1, "%" + employeeName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}

	public List<Borrowed> findByCustomerName(String customerName) {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId, employee.name AS employeeName, customer.name AS customerName\r\n"
							+ "FROM borrowed, borrow, employee, customer\r\n"
							+ "WHERE borrowed.id_borrow = borrow.id\r\n" + "AND borrow.id_employee = employee.id\r\n"
							+ "AND borrow.id_customer = customer.id\r\n" + "AND customer.name LIKE ?");

			preparedStatement.setString(1, "%" + customerName + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}

	public List<Borrowed> findByCreated(Date created) {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId\r\n"
							+ "FROM borrowed LEFT JOIN borrow ON borrowed.id_borrow = borrow.id WHERE borrowed.created = ?");

			preparedStatement.setDate(1, new java.sql.Date(created.getTime()));
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}

	public List<Borrowed> findByCreatedDESC() {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId\r\n"
							+ "FROM borrowed LEFT JOIN borrow ON borrowed.id_borrow = borrow.id ORDER BY borrowed.created DESC");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}

	public List<Borrowed> findByCreatedASC() {
		List<Borrowed> borrowedList = new ArrayList<Borrowed>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"SELECT borrowed.*, borrow.id_employee AS employeeId, borrow.id_customer AS customerId\r\n"
							+ "FROM borrowed LEFT JOIN borrow ON borrowed.id_borrow = borrow.id ORDER BY borrowed.created ASC");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Borrowed borrowed = new Borrowed();
				borrowed.setId(resultSet.getInt("id"));
				borrowed.setId_borrow(resultSet.getInt("id_borrow"));
				borrowed.setCreated_borrow(resultSet.getDate("created_borrow"));
				borrowed.setDue_date_borrow(resultSet.getDate("due_date_borrow"));
				borrowed.setCreated(resultSet.getDate("created"));
				borrowed.setOverdue_day(resultSet.getInt("overdue_day"));
				borrowed.setDeposit_borrow(resultSet.getDouble("deposit_borrow"));
				borrowed.setFines(resultSet.getDouble("fines"));
				borrowed.setTotal(resultSet.getDouble("total"));
				borrowed.setEmployeeId(resultSet.getInt("employeeId"));
				borrowed.setCustomerId(resultSet.getInt("customerId"));

				borrowedList.add(borrowed);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowedList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowedList;
	}
}
