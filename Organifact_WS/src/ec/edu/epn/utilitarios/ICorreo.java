package ec.edu.epn.utilitarios;

import java.util.Date;

import javax.mail.Message;
import javax.mail.Store;

public interface ICorreo {
	public Message[] buscarMensajesPorProveedor(String proveedor, Store store, Date fecha);
	public Message[] buscarMensajesPorAsunto(String asunto, Store store);
	public Message[] buscarMensajesPorRemitente( String correoRemitente);
	public boolean autenticar( String host, String port, String usuario, String contraseña);
	public boolean crearCarpetas();
	public boolean eliminarCarpetas();
	public Store obtenerSesion( String host, String port, String usuario, String contraseña);
	//buscarMensajesPor
}
