package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.PathParam;

import facade.AbstractFacade;
import facade.UsuarioFacade;
import model.Publicacion;
import model.Usuario;

@Stateless
public class UsuarioFacadeEJB extends AbstractFacade<Usuario> implements UsuarioFacade {
	
	
	@PersistenceContext(unitName = "tbd2016")
	private EntityManager em;
	
	public UsuarioFacadeEJB() {
		super(Usuario.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return this.em;
	}
	
	public List<Usuario> listarUsuarios()
	{
		 List<Usuario> listaDeUsuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
		 return listaDeUsuarios;
	}
	
	public Usuario obtenerUsuarioPorId(int idBuscada)
	{
		List<Usuario> UsuarioBuscado = em.createQuery("SELECT u FROM Usuario u WHERE u.idUsuario = :parametroDeId").setParameter("parametroDeId", idBuscada).getResultList();
		 return UsuarioBuscado.get(0);
	}
	
	public Usuario buscarPorNombreDeUsuario(String nombreDelUsuarioBuscado)
	{
		 List<Usuario> usuarioBuscado = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario LIKE :parametroDeNombre").setParameter("parametroDeNombre", nombreDelUsuarioBuscado).getResultList();
		 if (usuarioBuscado.size() != 0)
		 {
			 Usuario usuarioARetornar = usuarioBuscado.get(0);
			 return usuarioARetornar;
		 }
		 Usuario nuevoUsuario = new Usuario();
		 nuevoUsuario.setNicknameusuario("");
		 nuevoUsuario.setPasswordusuario("");
		 return nuevoUsuario;
	}
	
	public List<Publicacion> publicacionesDeUnUsuario(Usuario usuarioABuscarPublicaciones)
	{
		List<Publicacion> publicacionesDelUsuario = new ArrayList<Publicacion>();
		List<Publicacion> publicacionesTotales = new ArrayList<Publicacion>();
		publicacionesTotales = em.createQuery("SELECT u FROM Publicacion u").getResultList();
		for(Publicacion cadaPublicacion : publicacionesTotales)
		{
			if(cadaPublicacion.getUsuario().getIdUsuario() == usuarioABuscarPublicaciones.getIdUsuario())
			{
				publicacionesDelUsuario.add(cadaPublicacion);
			}
		}
		return publicacionesDelUsuario;	
	}
	

}
