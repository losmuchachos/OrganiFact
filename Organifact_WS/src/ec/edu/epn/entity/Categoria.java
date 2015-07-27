package ec.edu.epn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the categoria database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cat")
	private int idCat;

	@Column(name="nombre_cat")
	private String nombreCat;

	//bi-directional many-to-one association to Clasificacion
	@OneToMany(mappedBy="categoria")
	private List<Clasificacion> clasificacions;

	public Categoria() {
	}

	public int getIdCat() {
		return this.idCat;
	}

	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}

	public String getNombreCat() {
		return this.nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	public List<Clasificacion> getClasificacions() {
		return this.clasificacions;
	}

	public void setClasificacions(List<Clasificacion> clasificacions) {
		this.clasificacions = clasificacions;
	}

	public Clasificacion addClasificacion(Clasificacion clasificacion) {
		getClasificacions().add(clasificacion);
		clasificacion.setCategoria(this);

		return clasificacion;
	}

	public Clasificacion removeClasificacion(Clasificacion clasificacion) {
		getClasificacions().remove(clasificacion);
		clasificacion.setCategoria(null);

		return clasificacion;
	}

}