package service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import facade.UsuarioFacade;
import model.Usuario;
import model.Publicacion;

@Path("/usuarios")
public class UsuarioService {
	
	@EJB 
	UsuarioFacade UsuarioFacadeEJB;
	
	Logger logger = Logger.getLogger(UsuarioService.class.getName());
	
	@GET
	@Produces({"application/xml", "application/json"})
	public List<Usuario> findAll(){
		return UsuarioFacadeEJB.findAll();
	}
	
	@GET
	@Path("todoslosusuarios")
	@Produces("application/json")
	public List<Usuario> listarUsuarios(){
		return UsuarioFacadeEJB.listarUsuarios();
	}
	
	@GET
    @Path("buscarusuario/{id}")
    @Produces({"application/xml", "application/json"})
    public Usuario find(@PathParam("id") Integer id) {
        return UsuarioFacadeEJB.obtenerUsuarioPorId(id);
    }
	
	@GET
    @Path("buscarusuariopornombre/{nombreUsuario}")
    @Produces({"application/xml", "application/json"})
    public Usuario buscarUsuarioPorNombre(@PathParam("nombreUsuario") String nombreUsuario) {
        return UsuarioFacadeEJB.buscarPorNombreDeUsuario(nombreUsuario);
    }
	
	@GET
    @Path("buscarpublicacionesdeunusuario/{id}")
    @Produces({"application/xml", "application/json"})
    public List<Publicacion> buscarPublicacionesDeUnUsuario(@PathParam("id") Integer id) {
        Usuario usuarioABuscarPublicaciones = UsuarioFacadeEJB.find(id);
        return UsuarioFacadeEJB.publicacionesDeUnUsuario(usuarioABuscarPublicaciones);
    }
	
	@POST
	@Path("crearusuario")
    @Consumes({"application/xml", "application/json"})
    public void create(Usuario entity) {
        UsuarioFacadeEJB.create(entity);
    }
	
	@POST
	@Path("crearusuarioconcomprobaciondenombre")
    @Consumes({"application/xml", "application/json"})
    public Integer crearUsuarioAndroid(Usuario entity) {
		Usuario respuestaUsuario = UsuarioFacadeEJB.buscarPorNombreDeUsuario(entity.getNicknameusuario());
		if (respuestaUsuario.getNicknameusuario().equals(""))
		{
			UsuarioFacadeEJB.create(entity);
			Usuario usuarioCreado = UsuarioFacadeEJB.buscarPorNombreDeUsuario(entity.getNicknameusuario());
			return usuarioCreado.getIdUsuario();
		}
		return -1;
    }

    @PUT
    @Path("editarusuario/{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Usuario entity) {
    	entity.setIdUsuario(id.intValue());
        UsuarioFacadeEJB.edit(entity);
    }
    
    @POST
    @Path("logearusuario")
    @Consumes({"application/xml", "application/json"})
    public Usuario login(Usuario entity) 
    {
        List<Usuario> listaDeUsuarios = UsuarioFacadeEJB.listarUsuarios();
        for (Usuario usuarioAAnalizar : listaDeUsuarios)
        {
        	if(usuarioAAnalizar.getNicknameusuario().equals(entity.getNicknameusuario()) && usuarioAAnalizar.getPasswordusuario().equals(entity.getPasswordusuario()))
        		{
        			return usuarioAAnalizar;
        		}
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNicknameusuario("");
        nuevoUsuario.setPasswordusuario("");
        return nuevoUsuario;
    }
    
    @POST
    @Path("logearusuarionuevo")
    @Consumes({"application/xml", "application/json"})
    public Usuario loginNuevo(JsonObject usuarioYContra) 
    {
    	String nombreDeUsuario = usuarioYContra.getString("nombreUsuario");
    	String contrasena = usuarioYContra.getString("contrasena");
        List<Usuario> listaDeUsuarios = UsuarioFacadeEJB.listarUsuarios();
        for (Usuario usuarioAAnalizar : listaDeUsuarios)
        {
        	if(usuarioAAnalizar.getNicknameusuario().equals(nombreDeUsuario) && usuarioAAnalizar.getPasswordusuario().equals(contrasena))
        		{
        			return usuarioAAnalizar;
        		}
        }
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNicknameusuario("");
        nuevoUsuario.setPasswordusuario("");
        return nuevoUsuario;
    }
	
}
