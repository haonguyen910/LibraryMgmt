package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.BorrowDetail;

public class BorrowDetailModel {
//	One
	public boolean create(BorrowDetail borrowDetail) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("INSERT INTO borrow_detail(id_borrow, id_book, quantity, price) values(?,?,?,?)");

			preparedStatement.setInt(1, borrowDetail.getId_borrow());
			preparedStatement.setString(2, borrowDetail.getId_book());
			preparedStatement.setInt(3, borrowDetail.getQuantity());
			preparedStatement.setDouble(4, borrowDetail.getPrice());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(BorrowDetail borrowDetail) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE borrow_detail SET quantity = ? WHERE id = ?");

			preparedStatement.setInt(1, borrowDetail.getQuantity());
			preparedStatement.setInt(2, borrowDetail.getId());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean deleteByBorrowId(int id_borrow) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("DELETE FROM borrow_detail WHERE id_borrow = ?");

			preparedStatement.setInt(1, id_borrow);

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public BorrowDetail findOneByBookId(String callNumber) {
		BorrowDetail borrowDetail = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM borrow_detail WHERE id_book = ?");

			preparedStatement.setString(1, callNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				borrowDetail = new BorrowDetail();
				borrowDetail.setId(resultSet.getInt("id"));
				borrowDetail.setId_book(resultSet.getString("id_book"));
				borrowDetail.setId_borrow(resultSet.getInt("id_borrow"));
				borrowDetail.setQuantity(resultSet.getInt("quantity"));
				borrowDetail.setPrice(resultSet.getDouble("price"));

			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowDetail = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowDetail;
	}

//	List
	public List<BorrowDetail> findByBorrowId(int id) {
		List<BorrowDetail> borrowDetailList = new ArrayList<BorrowDetail>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM borrow_detail WHERE id_borrow = ?");

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				BorrowDetail borrowDetail = new BorrowDetail();
				borrowDetail.setId(resultSet.getInt("id"));
				borrowDetail.setId_book(resultSet.getString("id_book"));
				borrowDetail.setId_borrow(resultSet.getInt("id_borrow"));
				borrowDetail.setQuantity(resultSet.getInt("quantity"));
				borrowDetail.setPrice(resultSet.getDouble("price"));

				borrowDetailList.add(borrowDetail);
			}

		} catch (Exception e) {
			e.printStackTrace();
			borrowDetailList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return borrowDetailList;
	}

}
