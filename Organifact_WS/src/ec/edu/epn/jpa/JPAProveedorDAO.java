package ec.edu.epn.jpa;

import ec.edu.epn.dao.ProveedorDAO;
import ec.edu.epn.entity.Proveedor;

public class JPAProveedorDAO extends JPAGenericDAO<Proveedor, Integer>
implements ProveedorDAO{

	public JPAProveedorDAO() {
		super(Proveedor.class);
		// TODO Auto-generated constructor stub
	}

	
}
