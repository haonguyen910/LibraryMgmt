package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Book;

public class BookModel {
	public List<Book> findAll() {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT book.*, author.name AS author, category.name as category\r\n"
							+ "FROM book \r\n" + "LEFT JOIN book_author ON book.callNumber = book_author.id_book\r\n"
							+ "LEFT JOIN author ON author.id = book_author.id_author\r\n"
							+ "LEFT JOIN book_category ON book.callNumber = book_category.id_book\r\n"
							+ "LEFT JOIN category ON category.id = book_category.id_category");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setCallNumber(resultSet.getString("callNumber"));
				book.setISBN(resultSet.getString("ISBN"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
				book.setPhoto(resultSet.getString("photo"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));

				bookList.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
			bookList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return bookList;
	}

	public List<Book> findByKeyword(String keyword) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT book.*, author.name AS author, category.name as category\r\n"
							+ "FROM book \r\n" + "LEFT JOIN book_author ON book.callNumber = book_author.id_book\r\n"
							+ "LEFT JOIN author ON author.id = book_author.id_author\r\n"
							+ "LEFT JOIN book_category ON book.callNumber = book_category.id_book\r\n"
							+ "LEFT JOIN category ON category.id = book_category.id_category\r\n"
							+ "WHERE book.callNumber LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setCallNumber(resultSet.getString("callNumber"));
				book.setISBN(resultSet.getString("ISBN"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
				book.setPhoto(resultSet.getString("photo"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));

				bookList.add(book);
			}

		} catch (Exception e) {
			e.printStackTrace();
			bookList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return bookList;
	}

}
