package models;

import java.sql.PreparedStatement;

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
}
