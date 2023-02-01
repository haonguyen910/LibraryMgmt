package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Author;
import entities.Book;
import entities.Book_Author;

public class AuthorModel {
//	One
	public boolean create(Author auhtor) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into author(name) values(?)");

			preparedStatement.setString(1, auhtor.getName());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(Author auhtor) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE author set name = ? WHERE id = ?");

			preparedStatement.setString(1, auhtor.getName());
			preparedStatement.setInt(2, auhtor.getId());

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
					.prepareStatement("DELETE FROM author WHERE id = ?");

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

	public Author findOneByName(String name) {
		Author author = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM author WHERE name = ?");

			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				author = new Author();
				author.setId(resultSet.getInt("id"));
				author.setName(resultSet.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			author = null;
		} finally {
			ConnectDB.disconnect();
		}
		return author;
	}

	public Author find(int id) {
		Author author = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM author WHERE id = ?");

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				author = new Author();
				author.setId(resultSet.getInt("id"));
				author.setName(resultSet.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			author = null;
		} finally {
			ConnectDB.disconnect();
		}
		return author;
	}

	// List
	public List<Author> findAll() {
		List<Author> authorList = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT * FROM author");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Author author = new Author();
				author.setId(resultSet.getInt("id"));
				author.setName(resultSet.getString("name"));

				authorList.add(author);
			}

		} catch (Exception e) {
			e.printStackTrace();
			authorList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return authorList;
	}

	public List<Author> findByKeyword(String name) {
		List<Author> authorList = new ArrayList<Author>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM author WHERE name LIKE ?");

			preparedStatement.setString(1, "%" + name + "%");
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Author author = new Author();
				author.setId(resultSet.getInt("id"));
				author.setName(resultSet.getString("name"));

				authorList.add(author);
			}

		} catch (Exception e) {
			e.printStackTrace();
			authorList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return authorList;
	}

}
