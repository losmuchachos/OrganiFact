package ec.edu.epn.utilitarios;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;

public class ImplCorreo implements ICorreo {

	public Message[] buscarMensajesPorAsunto(String asunto, Store store) {
		
		try {
			Folder folderInbox= store.getFolder("INBOX");
			 folderInbox.open(Folder.READ_WRITE);
	         
			 //busqueda
			 SearchTerm searchCondition = new SubjectTerm(asunto);
	            folderInbox.search(searchCondition);
	            
	 
	            // performs search through the folder
	            Message[] foundMessages = folderInbox.search(searchCondition);
	            for (int i = 0; i < foundMessages.length; i++) {
	                Message message = foundMessages[i];
	                String subject = message.getSubject();
	                System.out.println("Found message #" + i + ": " + subject);
	               
	            }
	            
	            // disconnect
	            folderInbox.close(false);
	            store.close();
	            return foundMessages;
		} catch (MessagingException e) {
			System.out.println("error");
			e.printStackTrace();
			return null;
		}
	
		
		
	}

	public Message[] buscarMensajesPorRemitente(String correoRemitente) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean autenticar(String host, String port, String usuario, String contraseña){
		 Properties properties = new Properties();
	        
		 
	        // server setting
	        properties.put("mail.imap.host", host);
	        properties.put("mail.imap.port", port);
	        
	 
	        // SSL setting
	        properties.setProperty("mail.imap.socketFactory.class",
	                "javax.net.ssl.SSLSocketFactory");
	        properties.setProperty("mail.imap.socketFactory.fallback", "false");
	        properties.setProperty("mail.imap.socketFactory.port",
	                String.valueOf(port));
	        
	 
	        Session session = Session.getDefaultInstance(properties);
	        
	        try {
	            // connects to the message store
	            Store store = session.getStore("imap");
	            store.connect(usuario, contraseña);
	            System.out.println("Usuario autenticado con éxito");
	            return true;
	        }
	        catch (NoSuchProviderException ex) {
	            System.out.println("No existe proveedor de correo.");
	            ex.printStackTrace();
	            return false;
	        } catch (MessagingException ex) {
	            System.out.println("No se pudo conectar al store de mensajes");
	            ex.printStackTrace();
	            return false;
	        }
		
	}
	public Store obtenerSesion(String host, String port, String usuario, String contraseña) {
		 Properties properties = new Properties();
	        
		 
	        // server setting
	        properties.put("mail.imap.host", host);
	        properties.put("mail.imap.port", port);
	        
	 
	        // SSL setting
	        properties.setProperty("mail.imap.socketFactory.class",
	                "javax.net.ssl.SSLSocketFactory");
	        properties.setProperty("mail.imap.socketFactory.fallback", "false");
	        properties.setProperty("mail.imap.socketFactory.port",
	                String.valueOf(port));
	        
	 
	        Session session = Session.getDefaultInstance(properties);
	        
	        try {
	            // connects to the message store
	            Store store = session.getStore("imap");
	            store.connect(usuario, contraseña);
	            return store;
	        }
	        catch (NoSuchProviderException ex) {
	            System.out.println("No provider.");
	            ex.printStackTrace();
	            return null;
	        } catch (MessagingException ex) {
	            System.out.println("Could not connect to the message store.");
	            ex.printStackTrace();
	            return null;
	        }
	        
	}

	public boolean crearCarpetas() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean eliminarCarpetas() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

	public Message[] buscarMensajesPorProveedor(String proveedor, Store store, Date fecha) {
		try {
			Folder folderInbox= store.getFolder("INBOX");
			 folderInbox.open(Folder.READ_WRITE);
	
	            Message[] messages = folderInbox.getMessages();
	            Message[] encontrados= new Message[100];
	            System.out.println(folderInbox.getNewMessageCount());
	            	            
	            int contador=0;
	               for (int i = messages.length; i >messages.length-100; i--) {
	                Message message = messages[i-1];
	                System.out.println(i);
	              
	                Address[] address = message.getFrom();
	                
	             
	                if(( address[0].toString().contains(proveedor))){
	                	
	                	encontrados[contador]=message;
	                	contador++;
	                	 System.out.println("Found message #" + i + ": " + address[0].toString());
	                }
	                      
	               
	            }
	               System.out.println("búsqueda finalizada");
	                           
	            // disconnect
	            folderInbox.close(false);
	            store.close();
	            return encontrados;
		} catch (MessagingException e) {
			System.out.println("error");
			e.printStackTrace();
			return null;
		}
	
		
	}

	
	

}
