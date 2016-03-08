package br.com.inso.contatosinso.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;




/*
 * 
 * Classe responsável pelo mapeamento O.R.
 * 
 */

@Entity (name="OrigemContato")
public class OrigemContato implements Serializable {

	private static final long serialVersionUID = -4931943462193308601L;


	@Id
	@NotNull	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idOrigemContato", nullable = false)
	private int IdOrigemContato;

	@NotNull
	@Column(name="OrigemContato", nullable = false, length=50)
	private String OrigemContato;


	@OneToMany (fetch = FetchType.LAZY) //(cascade=CascadeType.PERSIST)//
	@JoinColumn(name = "IdOrigemContato")
	private List<Cliente> clientes;
	
	
	
	/**
	 * @return the idOrigemContato
	 */
	public int getIdOrigemContato() {
		return IdOrigemContato;
	}


	/**
	 * @param idOrigemContato the idOrigemContato to set
	 */
	public void setIdOrigemContato(int idOrigemContato) {
		IdOrigemContato = idOrigemContato;
	}


	/**
	 * @return the origemContato
	 */
	public String getOrigemContato() {
		return OrigemContato;
	}


	/**
	 * @param origemContato the origemContato to set
	 */
	public void setOrigemContato(String origemContato) {
		OrigemContato = origemContato;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + IdOrigemContato;
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
		OrigemContato other = (OrigemContato) obj;
		if (IdOrigemContato != other.IdOrigemContato)
			return false;
		return true;
	}

	
	
}
