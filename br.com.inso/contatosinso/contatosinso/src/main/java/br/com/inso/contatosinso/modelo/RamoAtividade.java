package br.com.inso.contatosinso.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity (name="RamosAtividade")
public class RamoAtividade implements Serializable{


	private static final long serialVersionUID = 5262569877573544995L;

	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAtividade", nullable = false)
	private int IdAtividade;

	
	
	@NotNull
	@Column(name="Atividade", nullable = false, length=50)
	private String Atividade;


	/**
	 * @return the idAtividade
	 */
	public int getIdAtividade() {
		return IdAtividade;
	}


	/**
	 * @param idAtividade the idAtividade to set
	 */
	public void setIdAtividade(int idAtividade) {
		IdAtividade = idAtividade;
	}


	/**
	 * @return the atividade
	 */
	public String getAtividade() {
		return Atividade;
	}


	/**
	 * @param atividade the atividade to set
	 */
	public void setAtividade(String atividade) {
		Atividade = atividade;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdAtividade;
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
		RamoAtividade other = (RamoAtividade) obj;
		if (IdAtividade != other.IdAtividade)
			return false;
		return true;
	}

	
	
}
