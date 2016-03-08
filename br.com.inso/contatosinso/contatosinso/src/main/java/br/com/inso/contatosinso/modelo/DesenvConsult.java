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

@Entity (name="DesenvConsult")
public class DesenvConsult implements Serializable {

	
	private static final long serialVersionUID = 1139394271405224560L;


	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id", nullable = false)
	private int Id;

	
	
	@NotNull
	@Column(name="Nome", nullable = false, length=50)
	private String Nome;


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
	 * @return the nome
	 */
	public String getNome() {
		return Nome;
	}


	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		Nome = nome;
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
		DesenvConsult other = (DesenvConsult) obj;
		if (Id != other.Id)
			return false;
		return true;
	}



	
	
}
