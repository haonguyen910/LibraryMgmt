package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Author;
import entities.Book;

public class AuthorModel {
	public Author findByName(String name) {
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

}
