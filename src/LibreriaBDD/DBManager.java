package LibreriaBDD;
import java.sql.*;

public class DBManager {
	private static final String DB_DRIVER = "org.h2.Driver";
	private static final String DB_BASE_URL = "jdbc:h2:tcp://localhost//C:/Users/Mauricio/Desktop/UP/Laboratorio 1/Semana9/ejemplo";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	public static Connection connect() {
		Connection c = null;
		try {
			Class.forName(DB_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}
		try {
			c = DriverManager.getConnection(DB_BASE_URL, DB_USERNAME, DB_PASSWORD);
			c.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		//retorno la conexion
		return c;
	}


	public static void cerrarBDD(Connection c){
		try {
			c.close()
		} catch (SQLException e){
			e.printStackTrace();
			throw new BDDException();
		}
	}


	public static void transaccion(Connection c, String sentenciaSQL){
		try {
			Statement s = c.createStatement();
			s.executeUpdate(sentenciaSQL);
			c.commit();
		} catch (SQLException e) {
			c.rollback();
			throw new BDDException();
		} finally {
			cerrarBDD(c);
		}
    }


	public static ResultSet consulta(Connection c, String sentenciaSQL) {
		try {
			Statement s = c.createStatement();
			ResultSet rs = s.executeQuery(sentenciaSQL); 
		} catch (SQLException e){
			try {
				c.rollback();
				e.printStackTrace();
			} catch (SQLException e1){
				throw new BDDException();
			}
		} finally {
			cerrarBDD(c);
		}
	}
}
