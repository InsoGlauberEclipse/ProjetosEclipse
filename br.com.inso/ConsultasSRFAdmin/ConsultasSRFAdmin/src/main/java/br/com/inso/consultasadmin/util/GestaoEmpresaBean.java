package br.com.inso.consultasadmin.util;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class GestaoEmpresaBean {
	
	private String NomeFantasia = "Fantasia";
	private String RazoSocial = "RazaoSocial";
	
	
	/**
	 * @return the nomeFantasia
	 */
	public String getNomeFantasia() {
		return NomeFantasia;
	}
	/**
	 * @param nomeFantasia the nomeFantasia to set
	 */
	public void setNomeFantasia(String nomeFantasia) {
		NomeFantasia = nomeFantasia;
	}
	/**
	 * @return the razoSocial
	 */
	public String getRazoSocial() {
		return RazoSocial;
	}
	/**
	 * @param razoSocial the razoSocial to set
	 */
	public void setRazoSocial(String razoSocial) {
		RazoSocial = razoSocial;
	}	

}
