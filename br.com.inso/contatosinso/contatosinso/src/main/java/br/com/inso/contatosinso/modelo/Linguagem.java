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

@Entity (name="Linguagem")
public class Linguagem implements Serializable {

	private static final long serialVersionUID = -8042378918358262081L;


	@Id
	@NotNull	
	@Column(name="IdLinguagem", nullable = false)
	private int IdLinguagem;

	
	
	@NotNull
	@Column(name="Linguagem", nullable = false, length=50)
	private String Linguagem;


	/**
	 * @return the idLinguagem
	 */
	public int getIdLinguagem() {
		return IdLinguagem;
	}


	/**
	 * @param idLinguagem the idLinguagem to set
	 */
	public void setIdLinguagem(int idLinguagem) {
		IdLinguagem = idLinguagem;
	}


	/**
	 * @return the linguagem
	 */
	public String getLinguagem() {
		return Linguagem;
	}


	/**
	 * @param linguagem the linguagem to set
	 */
	public void setLinguagem(String linguagem) {
		Linguagem = linguagem;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdLinguagem;
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
		Linguagem other = (Linguagem) obj;
		if (IdLinguagem != other.IdLinguagem)
			return false;
		return true;
	}



	
	
}
