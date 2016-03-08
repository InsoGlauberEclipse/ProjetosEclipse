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

@Entity (name="Departamento")
public class Departamento implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -4682111242902188800L;


	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdDepartamento", nullable = false)
	private int IdDepartamento;

	
	
	@NotNull
	@Column(name="Departamento", nullable = false, length=50)
	private String Departamento;


	/**
	 * @return the idDepartamento
	 */
	public int getIdDepartamento() {
		return IdDepartamento;
	}


	/**
	 * @param idDepartamento the idDepartamento to set
	 */
	public void setIdDepartamento(int idDepartamento) {
		IdDepartamento = idDepartamento;
	}


	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return Departamento;
	}


	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdDepartamento;
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
		Departamento other = (Departamento) obj;
		if (IdDepartamento != other.IdDepartamento)
			return false;
		return true;
	}


	


	
	
}
