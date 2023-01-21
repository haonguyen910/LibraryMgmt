package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Book;

public class BookModel {
//	One
	public boolean create(Book book) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"insert into book(callNumber, ISBN, title, quantity, price, photo, description, status, created) values(?,?,?,?,?,?,?,?,?)");

			preparedStatement.setString(1, book.getCallNumber());
			preparedStatement.setString(2, book.getISBN());
			preparedStatement.setString(3, book.getTitle());
			preparedStatement.setInt(4, book.getQuantity());
			preparedStatement.setDouble(5, book.getPrice());
			preparedStatement.setBytes(6, book.getPhoto());
			preparedStatement.setString(7, book.getDescription());
			preparedStatement.setBoolean(8, book.isStatus());
			preparedStatement.setDate(9, new java.sql.Date(book.getCreated().getTime()));

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(Book book) {
		boolean result = true;
		try {
//			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
//					"UPDATE book set ISBN = ?, title = ?, quantity = ?, price = ?, photo = ?, description = ?, status = ?, created = ? WHERE callNumber = ?");

			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement(
					"UPDATE book set ISBN = ?, title = ?, quantity = ?, price = ?, description = ?, status = ?, created = ? WHERE callNumber = ?");

			preparedStatement.setString(1, book.getISBN());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setInt(3, book.getQuantity());
			preparedStatement.setDouble(4, book.getPrice());
//			preparedStatement.setBytes(5, book.getPhoto());
			preparedStatement.setString(5, book.getDescription());
			preparedStatement.setBoolean(6, book.isStatus());
			preparedStatement.setDate(7, new java.sql.Date(book.getCreated().getTime()));
			preparedStatement.setString(8, book.getCallNumber());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean delete(String callNumber) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("DELETE FROM book WHERE callNumber = ?");

			preparedStatement.setString(1, callNumber);
			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public Book find(String callNumber) {
		Book book = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT book.*, author.name AS author, category.name as category\r\n"
							+ "FROM book \r\n" + "LEFT JOIN book_author ON book.callNumber = book_author.id_book\r\n"
							+ "LEFT JOIN author ON author.id = book_author.id_author\r\n"
							+ "LEFT JOIN book_category ON book.callNumber = book_category.id_book\r\n"
							+ "LEFT JOIN category ON category.id = book_category.id_category\r\n"
							+ "WHERE book.callNumber = ?");

			preparedStatement.setString(1, callNumber);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				book = new Book();
				book.setCallNumber(resultSet.getString("callNumber"));
				book.setISBN(resultSet.getString("ISBN"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setCreated(resultSet.getDate("created"));
				book.setPhoto(resultSet.getBytes("photo"));
				book.setAuthor(resultSet.getString("author"));
				book.setCategory(resultSet.getString("category"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			book = null;
		} finally {
			ConnectDB.disconnect();
		}
		return book;
	}

//	List
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
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setCreated(resultSet.getDate("created"));
				book.setPhoto(resultSet.getBytes("photo"));
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

	public List<Book> findByCallNumber(String callNumber) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT book.*, author.name AS author, category.name as category\r\n"
							+ "FROM book \r\n" + "LEFT JOIN book_author ON book.callNumber = book_author.id_book\r\n"
							+ "LEFT JOIN author ON author.id = book_author.id_author\r\n"
							+ "LEFT JOIN book_category ON book.callNumber = book_category.id_book\r\n"
							+ "LEFT JOIN category ON category.id = book_category.id_category\r\n"
							+ "WHERE book.callNumber LIKE ?");

			preparedStatement.setString(1, "%" + callNumber + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setCallNumber(resultSet.getString("callNumber"));
				book.setISBN(resultSet.getString("ISBN"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setCreated(resultSet.getDate("created"));
				book.setPhoto(resultSet.getBytes("photo"));
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

	public List<Book> findByISBN(String ISBN) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT book.*, author.name AS author, category.name as category\r\n"
							+ "FROM book \r\n" + "LEFT JOIN book_author ON book.callNumber = book_author.id_book\r\n"
							+ "LEFT JOIN author ON author.id = book_author.id_author\r\n"
							+ "LEFT JOIN book_category ON book.callNumber = book_category.id_book\r\n"
							+ "LEFT JOIN category ON category.id = book_category.id_category\r\n"
							+ "WHERE book.ISBN LIKE ?");

			preparedStatement.setString(1, "%" + ISBN + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setCallNumber(resultSet.getString("callNumber"));
				book.setISBN(resultSet.getString("ISBN"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setCreated(resultSet.getDate("created"));
				book.setPhoto(resultSet.getBytes("photo"));
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

	public List<Book> findByTitle(String title) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT book.*, author.name AS author, category.name as category\r\n"
							+ "FROM book \r\n" + "LEFT JOIN book_author ON book.callNumber = book_author.id_book\r\n"
							+ "LEFT JOIN author ON author.id = book_author.id_author\r\n"
							+ "LEFT JOIN book_category ON book.callNumber = book_category.id_book\r\n"
							+ "LEFT JOIN category ON category.id = book_category.id_category\r\n"
							+ "WHERE book.title LIKE ?");

			preparedStatement.setString(1, "%" + title + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setCallNumber(resultSet.getString("callNumber"));
				book.setISBN(resultSet.getString("ISBN"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setCreated(resultSet.getDate("created"));
				book.setPhoto(resultSet.getBytes("photo"));
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

	public List<Book> findByAuthor(String auhtor) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT book.*, author.name AS author, category.name as category\r\n"
							+ "FROM book \r\n" + "LEFT JOIN book_author ON book.callNumber = book_author.id_book\r\n"
							+ "LEFT JOIN author ON author.id = book_author.id_author\r\n"
							+ "LEFT JOIN book_category ON book.callNumber = book_category.id_book\r\n"
							+ "LEFT JOIN category ON category.id = book_category.id_category\r\n"
							+ "WHERE author.name LIKE ?");

			preparedStatement.setString(1, "%" + auhtor + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Book book = new Book();
				book.setCallNumber(resultSet.getString("callNumber"));
				book.setISBN(resultSet.getString("ISBN"));
				book.setTitle(resultSet.getString("title"));
				book.setDescription(resultSet.getString("description"));
				book.setPrice(resultSet.getDouble("price"));
				book.setQuantity(resultSet.getInt("quantity"));
				book.setStatus(resultSet.getBoolean("status"));
				book.setCreated(resultSet.getDate("created"));
				book.setPhoto(resultSet.getBytes("photo"));
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
