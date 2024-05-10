package LibreriaBDD;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UsuarioDAOH2Impl implements UsuarioDAO{

	public void crearUsuario(Usuario unUsuario) throws BDDException {
		String user = unUsuario.getUser();
		String email = unUsuario.getEmail();
	    String pass = unUsuario.getPass();

        Connection c = DBManager.connect();
        String sentenciaSQL = "INSERT INTO usuarios (user, email, pass) VALUES ('" + user +"', '"+email+",'"+pass+"')";
        DBManager.transaccion(sentenciaSQL);

	}

	public void borrarUsuario(String username) throws BDDException {
		String sentenciaSQL = "DELETE FROM usuarios WHERE user = '" + username + "'";
        Connection c = DBManager.connect();
        DBManager.transaccion(sentenciaSQL);		
	}

	
	public void actualizarUsuario(Usuario unUsuario) throws BDDException{
        String user = unUsuario.getUser();
        String email = unUsuario.getEmail();
        String pass = unUsuario.getPass();

        String sentenciaSQL = "UPDATE usuarios set email = '" + email + "', pass = '" + pass + "' WHERE user = '" + user + "'";
        DBManager.transaccion(sentenciaSQL);
	}

	
	public Usuario muestraUsuario(String username) throws BDDException{
		String sentenciaSQL = "SELECT * FROM usuarios WHERE user = '" + username + "'";
		Usuario usuario = null;
		ResultSet rs = DBManager.consulta(sentenciaSQL);
		
		
		try {
			if (rs.next()) {
				String user = rs.getString("user");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				usuario = new Usuario(user, email, pass);
			}
		} catch (SQLException e) {
			throw new BDDException();
		}
		
		return usuario;
	}

	public List<Usuario> listaTodosLosUsuarios() throws BDDException{
		String sentenciaSQL = "SELECT * FROM usuarios";
		List<Usuario> lista = new ArrayList<>();
		ResultSet rs = DBManager.consulta(sentenciaSQL);
		
		try {
			while (rs.next()) {
				String user = rs.getString("user");
				String pass = rs.getString("pass");
				String email = rs.getString("email");
				Usuario usuario = new Usuario(user, email, pass);
				lista.add(usuario);
			}
		} catch (SQLException e) {
			throw new BDDException();
		}
		
		return lista;
	}

}
