 package ec.edu.epn.jpa;


import ec.edu.epn.dao.DAOFactory;
import ec.edu.epn.dao.UsuarioDAO;



public class JPADAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO  getUsuarioDAO() {
		return new JPAUsuarioDAO();
	}

}

	