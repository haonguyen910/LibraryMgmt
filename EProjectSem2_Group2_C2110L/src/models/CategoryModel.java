package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entities.Author;
import entities.Category;

public class CategoryModel {
//	One
	public boolean create(Category category) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("insert into category(name) values(?)");

			preparedStatement.setString(1, category.getName());

			result = preparedStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			ConnectDB.disconnect();
		}
		return result;
	}

	public boolean update(Category category) {
		boolean result = true;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("UPDATE category set name = ? WHERE id = ?");

			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, category.getId());

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
					.prepareStatement("DELETE FROM category WHERE id = ?");

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

	public Category find(int id) {
		Category category = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM category WHERE id = ?");

			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			category = null;
		} finally {
			ConnectDB.disconnect();
		}
		return category;
	}

	public Category findOneByName(String name) {
		Category category = null;
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM category WHERE name = ?");

			preparedStatement.setString(1, name);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				category = new Category();
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			category = null;
		} finally {
			ConnectDB.disconnect();
		}
		return category;
	}

// List
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

	public List<Category> findByKeyword(String keyword) {
		List<Category> categoryList = new ArrayList<Category>();
		try {
			PreparedStatement preparedStatement = ConnectDB.connection()
					.prepareStatement("SELECT * FROM category WHERE name LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
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
