package org.jugni.apps.pico.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Clase que representa la entidad o tabla Cuentas.
 * 
 * @author gacs
 */

@Entity
@Table(name = "Cuentas" ,
indexes = {@Index(name = "idx_cuenta", columnList="Descripcion"),
		@Index(name = "idx_cuenta", columnList="Naturalesa")})
public class Cuenta {
  @Id()
  @Column(name="Id", length = 25)
  private String id;
  
  @Column(name="Descripcion", length = 50)
  private String descripcion;

  @Column(name="Nivel")
  private int nivel;
  
  @Column(name="Padre")
  private int padre;
  
  @Column(name="Naturalesa", length = 50)
  private String naturalesa;
  
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name="IdTipoCuenta")
  private TipoCuenta tipoCuenta;

  
  /**
   * Constructor Vacio requerido, para cuando no se tiene los valores 
   * al instanciar la clase cuenta
   */
  public Cuenta() {
    
  }

	public Cuenta(String id, String descripcion, int nivel, int padre, String naturalesa, TipoCuenta tipoCuenta) {
	this.id = id;
	this.descripcion = descripcion;
	this.nivel = nivel;
	this.padre = padre;
	this.naturalesa = naturalesa;
	this.tipoCuenta = tipoCuenta;
}
	/**
	 * Devuelve el valor del id de cuenta
	 * @return String
	 */
	public String getId() {
		return id;
	}
	/**
	 * Establece el valor de id de cuenta
	 * @param id
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Devuelve el nombre de la cuenta
	 * @return String
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Establece el nombre de la cuenta
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Devuelve el tipo de cuenta relacionado a la cuenta
	 * @return
	 */
	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}
	/**
	 * Establece el tipo de cuenta relacionado a la cuenta
	 * @param tipoCuenta
	 */
	public void setTipoCuenta(TipoCuenta tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	/**
	 * Devuelve el nivel de la cuenta
	 * @return
	 */
	public int getNivel() {
		return nivel;
	}
	/**
	 * Establece el nivel de la cuenta
	 * @param nivel
	 */
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	/**
	 * Devuelve el valor de la cuenta padre
	 * @return int
	 */
	public int getPadre() {
		return padre;
	}
	/**Establece el valor de la cuenta padre
	 * 
	 * @param padre
	 */
	public void setPadre(int padre) {
		this.padre = padre;
	}
	/**
	 * Devuelve la naturaleza de la cuenta
	 * @return
	 */
	public String getNaturalesa() {
		return naturalesa;
	}
	/**
	 * Establece la naturaleza de la cuenta
	 * @param naturalesa
	 */
	public void setNaturalesa(String naturalesa) {
		this.naturalesa = naturalesa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", descripcion=" + descripcion + ", nivel=" + nivel + ", padre=" + padre
				+ ", naturalesa=" + naturalesa + "]";
	}
}
