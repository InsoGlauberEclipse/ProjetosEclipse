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

@Entity (name="GerenteConta")
public class GerenteConta implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -3955732844077816330L;


	@Id
	@NotNull	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdGerente", nullable = false)
	private int IdGerente;

	
	
	@NotNull
	@Column(name="Gerente", nullable = false, length=50)
	private String Gerente;


	/**
	 * @return the idGerente
	 */
	public int getIdGerente() {
		return IdGerente;
	}


	/**
	 * @param idGerente the idGerente to set
	 */
	public void setIdGerente(int idGerente) {
		IdGerente = idGerente;
	}


	/**
	 * @return the gerente
	 */
	public String getGerente() {
		return Gerente;
	}


	/**
	 * @param gerente the gerente to set
	 */
	public void setGerente(String gerente) {
		Gerente = gerente;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdGerente;
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
		GerenteConta other = (GerenteConta) obj;
		if (IdGerente != other.IdGerente)
			return false;
		return true;
	}


	
	
}
