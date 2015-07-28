package ec.edu.epn.dao;


import ec.edu.epn.jpa.JPADAOFactory;


public abstract class DAOFactory {
    // Sería mejor por inyección de objetos
    protected static DAOFactory factory = new JPADAOFactory();

    public static DAOFactory getFactory() {
        return factory;
    }

    public abstract UsuarioDAO getUsuarioDAO();
    public abstract CategoriaDAO getCategoriaDAO();
    public abstract ClasificacionDAO getClasificacionDAO();
    public abstract ProveedorDAO getpProveedorDAO();
    
    
    
    
   
    


}