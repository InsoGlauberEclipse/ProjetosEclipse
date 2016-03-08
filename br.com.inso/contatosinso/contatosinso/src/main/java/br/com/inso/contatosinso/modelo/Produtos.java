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

@Entity (name="Produtos")
public class Produtos implements Serializable {

	private static final long serialVersionUID = -3121080637728688991L;


	@Id
	@NotNull	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable = false)
	private int Id;
	
	
	@NotNull
	@Column(name="Produto", nullable = false, length=50)
	private String Produto;

	
	@NotNull
	@Column(name="Versao", nullable = true, length=20)
	private String Versao;

	@Column(name="Release", nullable = true, length=20)
	private String Release;

		
	@Column(name="Build", nullable = true)
	private int Build;

	@Column(name="Observacao", nullable = true)
	private String Observacao;

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}

	/**
	 * @return the produto
	 */
	public String getProduto() {
		return Produto;
	}

	/**
	 * @param produto the produto to set
	 */
	public void setProduto(String produto) {
		Produto = produto;
	}

	/**
	 * @return the versao
	 */
	public String getVersao() {
		return Versao;
	}

	/**
	 * @param versao the versao to set
	 */
	public void setVersao(String versao) {
		Versao = versao;
	}

	/**
	 * @return the release
	 */
	public String getRelease() {
		return Release;
	}

	/**
	 * @param release the release to set
	 */
	public void setRelease(String release) {
		Release = release;
	}

	/**
	 * @return the build
	 */
	public int getBuild() {
		return Build;
	}

	/**
	 * @param build the build to set
	 */
	public void setBuild(int build) {
		Build = build;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return Observacao;
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Id;
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
		Produtos other = (Produtos) obj;
		if (Id != other.Id)
			return false;
		return true;
	}
	

	
	
}
