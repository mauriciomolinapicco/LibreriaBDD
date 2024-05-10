package LibreriaBDD;

import java.util.List;

public interface UsuarioDAO {
	void crearUsuario(Usuario unUsuario);

	void borrarUsuario(String username);

	void actualizarUsuario(Usuario unUsuario);

	Usuario muestraUsuario(String username);

	List<Usuario> listaTodosLosUsuarios();
}
