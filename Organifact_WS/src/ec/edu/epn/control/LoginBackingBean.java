package ec.edu.epn.control;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import ec.edu.epn.entity.Proveedor;
import ec.edu.epn.entity.Usuario;
import ec.edu.epn.jpa.JPADAOFactory;
import ec.edu.epn.jpa.JPAGenericDAO;




@ManagedBean(name = "loginControl")
@SessionScoped
public class LoginBackingBean {

	private List<Proveedor> proveedores;
	private List<Usuario> usuarios;
	private Usuario usuario;
	private String correoUsuario;
	private String claveUsuario;
	private List<String> listaNombreProveedores;
	
	
	public LoginBackingBean()
	{
		usuarios=JPADAOFactory.getFactory().getUsuarioDAO().find();
	}
	
	public String autenticar()
	{
		
		for(Usuario usu: usuarios)
		{
			if(!(usu.getCorreoUsu().equals(correoUsuario)))
			{
				FacesContext context = FacesContext.getCurrentInstance();
				 context.addMessage(null, new FacesMessage("OrganiFact",  "Usuario No Regitsrado") );
			}
			else
			{
				//Aqui Creamos Carpetas
			}
		}
		return null;
		
	}
	
	public void buscarProveedorbyUsuario()
	{
		
	}
	
	public String crearUsuario()
	{
		JPADAOFactory.getFactory().getUsuarioDAO().create(usuario);
		return null;	
	}
	
	
	//Getters And Setters
	public List<Proveedor> getProveedores() {
		return proveedores;
	}
	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	
}
