package com.mch01jdbc.studentManagement;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;

	public static Connection createConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String user = "root";
			String password = "your_password";
			String url = "jdbc:mysql://localhost:3306/mch01";

			con = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
