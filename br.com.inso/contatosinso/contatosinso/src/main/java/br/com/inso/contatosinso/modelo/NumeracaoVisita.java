package br.com.inso.contatosinso.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity (name="NumeracaoVisita")
public class NumeracaoVisita implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8923063185048961012L;



	@Id
	@NotNull	
	@Column(name="Ano", nullable = false)
	private Long Ano;

	
	
	@NotNull
	@Column(name="UltimoRelatorio", nullable = false)
	private Long UltimoRelatorio;



	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ano == null) ? 0 : Ano.hashCode());
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
		NumeracaoVisita other = (NumeracaoVisita) obj;
		if (Ano == null) {
			if (other.Ano != null)
				return false;
		} else if (!Ano.equals(other.Ano))
			return false;
		return true;
	}



	/**
	 * @return the ano
	 */
	public Long getAno() {
		return Ano;
	}



	/**
	 * @param ano the ano to set
	 */
	public void setAno(Long ano) {
		Ano = ano;
	}



	/**
	 * @return the ultimoRelatorio
	 */
	public Long getUltimoRelatorio() {
		return UltimoRelatorio;
	}



	/**
	 * @param ultimoRelatorio the ultimoRelatorio to set
	 */
	public void setUltimoRelatorio(Long ultimoRelatorio) {
		UltimoRelatorio = ultimoRelatorio;
	}

	

}
