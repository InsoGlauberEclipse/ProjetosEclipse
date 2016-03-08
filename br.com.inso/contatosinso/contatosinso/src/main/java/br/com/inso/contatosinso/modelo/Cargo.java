package br.com.inso.contatosinso.modelo;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;




/*
 * 
 * Classe responsável pelo mapeamento O.R.
 * 
 */

@Entity (name="Cargos")
public class Cargo implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1836292079559112846L;


	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCargo", nullable = false)
	private int IdCargo;

	
	
	@NotNull
	@Column(name="Cargo", nullable = false, length=50)
	private String Cargo;


	/**
	 * @return the idCargo
	 */
	public int getIdCargo() {
		return IdCargo;
	}


	/**
	 * @param idCargo the idCargo to set
	 */
	public void setIdCargo(int idCargo) {
		IdCargo = idCargo;
	}


	/**
	 * @return the cargo
	 */
	public String getCargo() {
		return Cargo;
	}


	/**
	 * @param cargo the cargo to set
	 */
	public void setCargo(String cargo) {
		Cargo = cargo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdCargo;
		return result;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		if (IdCargo != other.IdCargo)
			return false;
		return true;
	}


	


	
	
}
