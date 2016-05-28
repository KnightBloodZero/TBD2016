package facade;

import java.util.List;

import javax.ejb.Local;

import model.Publicacion;
import model.Usuario;

@Local
public interface UsuarioFacade {

	public void create(Usuario entity);

	public void edit(Usuario entity);

	public void remove(Usuario entity);

	public Usuario find(Object id);

	public List<Usuario> findAll();

	public List<Usuario> findRange(int[] range);

	public int count();
	
	public List<Usuario> listarUsuarios();
	
	public Usuario buscarPorNombreDeUsuario(String nombreDelUsuarioBuscado);
	
	public Usuario obtenerUsuarioPorId(int idBuscada);
	
	public List<Publicacion> publicacionesDeUnUsuario(Usuario usuarioABuscarPublicaciones);

}
