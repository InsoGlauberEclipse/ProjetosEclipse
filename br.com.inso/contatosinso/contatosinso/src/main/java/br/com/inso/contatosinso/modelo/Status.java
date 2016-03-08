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

@Entity (name="Status")

public class Status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4856363274753381795L;
	
	@Id
	@NotNull	
	@Column(name="IdStatus", nullable = false)
	private int IdStatus;

	
	
	@NotNull
	@Column(name="Descricao", nullable = false, length=50)
	private String Descricao;


	/**
	 * @return the idStatus
	 */
	public int getIdStatus() {
		return IdStatus;
	}


	/**
	 * @param idStatus the idStatus to set
	 */
	public void setIdStatus(int idStatus) {
		IdStatus = idStatus;
	}


	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return Descricao;
	}


	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdStatus;
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
		Status other = (Status) obj;
		if (IdStatus != other.IdStatus)
			return false;
		return true;
	}


	
	
	
	
}
