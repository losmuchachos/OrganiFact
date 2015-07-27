package ec.edu.epn.jpa;

import ec.edu.epn.dao.CategoriaDAO;
import ec.edu.epn.entity.Categoria;

public class JPACategoriaDAO extends JPAGenericDAO<Categoria, Integer> 
implements CategoriaDAO  {

	public JPACategoriaDAO() {
		super(Categoria.class);
		// TODO Auto-generated constructor stub
	}

	
	
}
