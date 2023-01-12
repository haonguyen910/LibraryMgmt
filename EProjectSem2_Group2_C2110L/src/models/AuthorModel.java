package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Author;

public class AuthorModel {
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
