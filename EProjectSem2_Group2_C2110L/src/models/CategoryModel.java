package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Category;

public class CategoryModel {
	public List<Category> findAll() {
		List<Category> categoryList = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection().prepareStatement("SELECT * FROM category");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Category category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));

				categoryList.add(category);
			}

		} catch (Exception e) {
			e.printStackTrace();
			categoryList = null;
		} finally {
			ConnectDB.disconnect();
		}
		return categoryList;
	}
}
