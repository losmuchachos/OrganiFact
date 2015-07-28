package ec.edu.epn.dao;

import ec.edu.epn.entity.Proveedor;
import ec.edu.epn.jpa.JPADAOFactory;

public class TestPersistencia {

	public static void main(String[] args) {
		Proveedor proveedor= new Proveedor();
		proveedor.setNombrePro("pepe");
		JPADAOFactory.getFactory().getpProveedorDAO().create(proveedor);

	}

}
