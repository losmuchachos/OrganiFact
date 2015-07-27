package ec.edu.epn.jpa;

import ec.edu.epn.dao.ClasificacionDAO;
import ec.edu.epn.entity.Clasificacion;

public class JPAClasificacionDAO extends JPAGenericDAO<Clasificacion, Integer>
implements ClasificacionDAO{

	public JPAClasificacionDAO() {
		super(Clasificacion.class);
		// TODO Auto-generated constructor stub
	}

	
	
}
