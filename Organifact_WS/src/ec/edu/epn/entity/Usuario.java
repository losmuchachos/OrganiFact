package ec.edu.epn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usu")
	private int idUsu;

	@Column(name="correo_usu")
	private String correoUsu;

	@Column(name="nombre_usu")
	private String nombreUsu;

	//bi-directional many-to-one association to Clasificacion
	@OneToMany(mappedBy="usuario")
	private List<Clasificacion> clasificacions;

	public Usuario() {
	}

	public int getIdUsu() {
		return this.idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public String getCorreoUsu() {
		return this.correoUsu;
	}

	public void setCorreoUsu(String correoUsu) {
		this.correoUsu = correoUsu;
	}

	public String getNombreUsu() {
		return this.nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public List<Clasificacion> getClasificacions() {
		return this.clasificacions;
	}

	public void setClasificacions(List<Clasificacion> clasificacions) {
		this.clasificacions = clasificacions;
	}

	public Clasificacion addClasificacion(Clasificacion clasificacion) {
		getClasificacions().add(clasificacion);
		clasificacion.setUsuario(this);

		return clasificacion;
	}

	public Clasificacion removeClasificacion(Clasificacion clasificacion) {
		getClasificacions().remove(clasificacion);
		clasificacion.setUsuario(null);

		return clasificacion;
	}

}