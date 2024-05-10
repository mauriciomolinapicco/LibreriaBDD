package LibreriaBDD;

import java.sql.*;

public class TableManager {
	public void createUserTable() {
		Connection c = DBManager.connect();
		
		String sql = "CREATE TABLE usuarios (id INTEGER IDENTIFY, user VARCHAR(256), email VARCHAR(256), pass VARCHAR(10)";
		
		try {
			Statement s = c.createStatement();
			s.execute(sql);
		} catch (SQLException e) {
			c.rollback();
			e.printStackTrace();
		} finally {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void dropUserTable() {
		Connection c = DBManager.connect();
		
		String sql = "DROP TABLE usuarios";
	}

}
