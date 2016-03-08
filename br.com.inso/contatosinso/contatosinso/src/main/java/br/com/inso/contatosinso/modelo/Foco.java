package br.com.inso.contatosinso.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;




/*
 * 
 * Classe responsável pelo mapeamento O.R.
 * 
 */

@Entity (name="Foco")
public class Foco implements Serializable {




	/**
	 * 
	 */
	private static final long serialVersionUID = -6920556525995882182L;

	

	@Id
	@NotNull	
	@Column(name="IdFoco", nullable = false)
	private int IdFoco;

	
	
	@NotNull
	@Column(name="Foco", nullable = false, length=50)
	private String Foco;


	/**
	 * @return the idFoco
	 */
	public int getIdFoco() {
		return IdFoco;
	}


	/**
	 * @param idFoco the idFoco to set
	 */
	public void setIdFoco(int idFoco) {
		IdFoco = idFoco;
	}


	/**
	 * @return the foco
	 */
	public String getFoco() {
		return Foco;
	}


	/**
	 * @param foco the foco to set
	 */
	public void setFoco(String foco) {
		Foco = foco;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdFoco;
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
		Foco other = (Foco) obj;
		if (IdFoco != other.IdFoco)
			return false;
		return true;
	}



	
	
}
