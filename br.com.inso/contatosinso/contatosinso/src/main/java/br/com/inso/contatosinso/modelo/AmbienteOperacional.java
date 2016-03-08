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

@Entity (name="AmbienteOperacional")
public class AmbienteOperacional implements Serializable {

	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdAmbiente", nullable = false)
	private Long IdAmbiente;

	
	
	@NotNull
	@Column(name="Ambiente", nullable = false, length=50)
	private String Ambiente;
	
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -1689293398555250710L;


	/**
	 * @return the idAmbiente
	 */
	public Long getIdAmbiente() {
		return IdAmbiente;
	}


	/**
	 * @param idAmbiente the idAmbiente to set
	 */
	public void setIdAmbiente(Long idAmbiente) {
		IdAmbiente = idAmbiente;
	}


	/**
	 * @return the ambiente
	 */
	public String getAmbiente() {
		return Ambiente;
	}


	/**
	 * @param ambiente the ambiente to set
	 */
	public void setAmbiente(String ambiente) {
		Ambiente = ambiente;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdAmbiente == null) ? 0 : IdAmbiente.hashCode());
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
		AmbienteOperacional other = (AmbienteOperacional) obj;
		if (IdAmbiente == null) {
			if (other.IdAmbiente != null)
				return false;
		} else if (!IdAmbiente.equals(other.IdAmbiente))
			return false;
		return true;
	}

	
	
	
}
