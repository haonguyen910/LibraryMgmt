package models;

import java.sql.PreparedStatement;

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
					.prepareStatement("UPDATE borrowDetail SET quantity = ? WHERE id = ?");

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
}
