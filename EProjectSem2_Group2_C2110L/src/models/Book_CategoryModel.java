package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	public boolean update(Book_Category book_category) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE book_category set id_category = ? WHERE id_book = ?");

			preparedStatement.setInt(1, book_category.getId_category());
			preparedStatement.setString(2, book_category.getId_book());

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
					.prepareStatement("DELETE FROM book_category WHERE id = ?");

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

	public Book_Category find(String id_book, int id_category) {
		Book_Category book_Category = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM book_Category WHERE id_book = ? AND id_category = ?");

			preparedStatement.setString(1, id_book);
			preparedStatement.setInt(2, id_category);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				book_Category = new Book_Category();
				book_Category.setId_category(resultSet.getInt("id_category"));
				book_Category.setId_book(resultSet.getString("id_book"));
				book_Category.setId(resultSet.getInt("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			book_Category = null;
		} finally {
			ConnectDB.disconnect();
		}
		return book_Category;
	}
}
