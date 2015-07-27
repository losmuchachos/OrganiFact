package ec.edu.epn.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the proveedor database table.
 * 
 */
@Entity
@NamedQuery(name="Proveedor.findAll", query="SELECT p FROM Proveedor p")
public class Proveedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_pro")
	private int idPro;

	@Column(name="correo_prov")
	private String correoProv;

	@Column(name="nombre_pro")
	private String nombrePro;

	private String RUC_pro;

	//bi-directional many-to-one association to Clasificacion
	@OneToMany(mappedBy="proveedor")
	private List<Clasificacion> clasificacions;

	public Proveedor() {
	}

	public int getIdPro() {
		return this.idPro;
	}

	public void setIdPro(int idPro) {
		this.idPro = idPro;
	}

	public String getCorreoProv() {
		return this.correoProv;
	}

	public void setCorreoProv(String correoProv) {
		this.correoProv = correoProv;
	}

	public String getNombrePro() {
		return this.nombrePro;
	}

	public void setNombrePro(String nombrePro) {
		this.nombrePro = nombrePro;
	}

	public String getRUC_pro() {
		return this.RUC_pro;
	}

	public void setRUC_pro(String RUC_pro) {
		this.RUC_pro = RUC_pro;
	}

	public List<Clasificacion> getClasificacions() {
		return this.clasificacions;
	}

	public void setClasificacions(List<Clasificacion> clasificacions) {
		this.clasificacions = clasificacions;
	}

	public Clasificacion addClasificacion(Clasificacion clasificacion) {
		getClasificacions().add(clasificacion);
		clasificacion.setProveedor(this);

		return clasificacion;
	}

	public Clasificacion removeClasificacion(Clasificacion clasificacion) {
		getClasificacions().remove(clasificacion);
		clasificacion.setProveedor(null);

		return clasificacion;
	}

}