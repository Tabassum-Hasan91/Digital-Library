
package com.atox.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Tabassum.Hasan
 */
public class CreateConnection 
{
    String driverClassName = "com.org.derby.jdbc.EmbeddedDriver";
	String connectionUrl = "jdbc:derby://localhost:1527/Library";

	String dbUser = "root";
	String dbPwd = "root";

	private static CreateConnection connectionFactory = null;

	private CreateConnection() {
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(connectionUrl, dbUser, dbPwd);
		return conn;
	}

	public static CreateConnection getInstance() {
		if (connectionFactory == null) {
			connectionFactory = new CreateConnection();
		}
		return connectionFactory;
	}
        
}
