package ec.edu.epn.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clasificacion database table.
 * 
 */
@Entity
@NamedQuery(name="Clasificacion.findAll", query="SELECT c FROM Clasificacion c")
public class Clasificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_clas")
	private int idClas;

	@Column(name="anio_clas")
	private String anioClas;

	@Column(name="mes_clas")
	private String mesClas;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_usu")
	private Usuario usuario;

	//bi-directional many-to-one association to Proveedor
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_pro")
	private Proveedor proveedor;

	//bi-directional many-to-one association to Categoria
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="id_cat")
	private Categoria categoria;

	public Clasificacion() {
	}

	public int getIdClas() {
		return this.idClas;
	}

	public void setIdClas(int idClas) {
		this.idClas = idClas;
	}

	public String getAnioClas() {
		return this.anioClas;
	}

	public void setAnioClas(String anioClas) {
		this.anioClas = anioClas;
	}

	public String getMesClas() {
		return this.mesClas;
	}

	public void setMesClas(String mesClas) {
		this.mesClas = mesClas;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Proveedor getProveedor() {
		return this.proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}