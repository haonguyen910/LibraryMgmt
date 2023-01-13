package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entities.Book_Author;

public class Book_AuthorModel {
	public boolean create(Book_Author book_auhtor) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into book_author(id_book, id_author) values(?,?)");

			preparedStatement.setString(1, book_auhtor.getId_book());
			preparedStatement.setInt(2, book_auhtor.getId_author());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(Book_Author book_auhtor) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE book_author set id_author = ? WHERE id_book = ?");

			preparedStatement.setInt(1, book_auhtor.getId_author());
			preparedStatement.setString(2, book_auhtor.getId_book());

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
					.prepareStatement("DELETE FROM book_author WHERE id = ?");

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

	public Book_Author find(String id_book, int id_author) {
		Book_Author book_Author = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM book_author WHERE id_book = ? AND id_author = ?");

			preparedStatement.setString(1, id_book);
			preparedStatement.setInt(2, id_author);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				book_Author = new Book_Author();
				book_Author.setId_author(resultSet.getInt("id_author"));
				book_Author.setId_book(resultSet.getString("id_book"));
				book_Author.setId(resultSet.getInt("id"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			book_Author = null;
		} finally {
			ConnectDB.disconnect();
		}
		return book_Author;
	}

}
