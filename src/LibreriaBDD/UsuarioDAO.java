package LibreriaBDD;

import java.util.List;

public interface UsuarioDAO {
	void crearUsuario(Usuario unUsuario) throws BDDException;

	void borrarUsuario(String username) throws BDDException;

	void actualizarUsuario(Usuario unUsuario) throws BDDException;

	Usuario muestraUsuario(String username) throws BDDException;

	List<Usuario> listaTodosLosUsuarios() throws BDDException;
}
