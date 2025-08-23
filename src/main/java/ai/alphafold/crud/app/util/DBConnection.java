package ai.alphafold.crud.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String DB_URL = "jdbc:sqlite:data/proteins.db";

	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(DB_URL);
	}
}