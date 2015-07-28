 package ec.edu.epn.jpa;


import ec.edu.epn.dao.CategoriaDAO;
import ec.edu.epn.dao.ClasificacionDAO;
import ec.edu.epn.dao.DAOFactory;
import ec.edu.epn.dao.ProveedorDAO;
import ec.edu.epn.dao.UsuarioDAO;



public class JPADAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO  getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		return new JPACategoriaDAO();
	}

	@Override
	public ClasificacionDAO getClasificacionDAO() {
		return new JPAClasificacionDAO();
	}

	@Override
	public ProveedorDAO getpProveedorDAO() {
		return new JPAProveedorDAO();
	}

}

	