package com.fp.cripto.password.repository;

import com.fp.cripto.common.PropertiesHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase de utilidad para obtener la conexión del driver
 */
public class DriverHelper {

	public static Connection getConnection() throws SQLException { 
		Connection conn = DriverManager.getConnection(PropertiesHandler.get("db.url"),
				PropertiesHandler.get("db.user"), PropertiesHandler.get("db.password"));
		return conn;
	}
}