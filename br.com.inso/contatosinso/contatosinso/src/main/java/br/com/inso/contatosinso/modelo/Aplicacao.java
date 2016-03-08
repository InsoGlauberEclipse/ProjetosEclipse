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

@Entity (name="Aplicacao")
public class Aplicacao implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2196399706007207732L;


	@Id
	@NotNull	
	@Column(name="IdAplicacao", nullable = false)
	private int IdAplicacao;

	
	
	@NotNull
	@Column(name="Descricao", nullable = false, length=50)
	private String Descricao;


	/**
	 * @return the idAplicacao
	 */
	public int getIdAplicacao() {
		return IdAplicacao;
	}


	/**
	 * @param idAplicacao the idAplicacao to set
	 */
	public void setIdAplicacao(int idAplicacao) {
		IdAplicacao = idAplicacao;
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
		result = prime * result + IdAplicacao;
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
		Aplicacao other = (Aplicacao) obj;
		if (IdAplicacao != other.IdAplicacao)
			return false;
		return true;
	}



	
		
	
	
	
}
