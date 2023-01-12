package models;

import java.sql.PreparedStatement;

import entities.Book_Category;

public class Book_CategoryModel {
	public boolean create(Book_Category book_category) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into book_category(id_book, id_category) values(?,?)");

			preparedStatement.setString(1, book_category.getId_book());
			preparedStatement.setInt(2, book_category.getId_category());

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
