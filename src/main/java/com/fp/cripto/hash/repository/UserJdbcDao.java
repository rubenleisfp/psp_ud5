package com.fp.cripto.hash.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class UserJdbcDao implements UserDao {

	private static final String USER_BY_ID = "SELECT * FROM usuario WHERE id = ?";


	private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
		User user = new User();
		user.setId(resultSet.getInt("id"));
		user.setUsername(resultSet.getString("USERNAME"));
		user.setPassword(resultSet.getString("PASSWORD"));
		return user;
	}



	@Override
	public User getUserById(int userId) {
		try (Connection connection = DriverHelper.getConnection()) {

			try (PreparedStatement preparedStatement = connection.prepareStatement(USER_BY_ID)) {
				preparedStatement.setInt(1, userId);

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					if (resultSet.next()) {
						return mapResultSetToUser(resultSet);
					} else {
						throw new SQLException("No se encontró el user con ID: " + userId);
					}
				}
			}
		} catch (SQLException e) {
			throw new RuntimeException("Error al obtener el user por ID: " + userId, e);
		}
	}
}