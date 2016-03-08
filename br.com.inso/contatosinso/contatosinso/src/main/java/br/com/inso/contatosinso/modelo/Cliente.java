package br.com.inso.contatosinso.modelo;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;



/*
 * 
 * Classe responsável pelo mapeamento O.R.
 * 
 */

@Entity (name="Clientes")

public class Cliente implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8752767025592134023L;
	
	
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="IdCliente", nullable = false)
	private Long IdCliente;
	
	
	@Column(name="Codigo",  length=20)
	private String Codigo;
	

	@NotNull
	@Column(name="RazaoSocial", nullable = false, length=50)
	private String RazaoSocial;

	
	@Column(name="Fantasia")
	private String Fantasia;
	
	@Column(name="Endereco")
	private String Endereco;
	
	@Column(name="Complemento")
	private String Complemento;
	
	@Column(name="Bairro")
	private String Bairro;
	
	@Column(name="Cidade")
	private String Cidade;

	@Column(name="Estado")
	private String Estado;
	
	@Column(name="CnpjCpf")
	private String CnpjCpf;
	
	@Column(name="InscRg")
	private String InscRg;
	
	@Column(name="Fonedd")
	private String Fonedd;
	
	@Column(name="Telefone1")
	private String Telefone1;
	
	@Column(name="Ramal1")
	private String Ramal1;
	
	@Column(name="Telefone2")
	private String Telefone2;
	
	@Column(name="Ramal2")
	private String Ramal2;
	
	@Column(name="Fax")
	private String Fax;
	
	@Column(name="RamalFax")
	private String RamalFax;
	
	@Column(name="Paginaweb")
	private String Paginaweb;

	@Column(name="EndEmail")
	private String EndEmail;
	
	@Column(name="Observacao")
	private String Observacao;
/*	
	@ManyToOne (fetch = FetchType.LAZY) //(cascade=CascadeType.PERSIST)//
	@JoinColumn(name = "IdOrigemContato")
	private OrigemContato origemcontato;
*/
	
	@ManyToOne (fetch = FetchType.LAZY )
	@JoinColumn(name = "IdGerenteConta")
	private GerenteConta gerenteconta;
	
	@Column(name="QtdLicencas")
	private Long QtdLicencas;
	
	@Column(name="NumeroSerie")
	private String NumeroSerie;
	
	@Column(name="CodCliMilton")
	private String CodCliMilton;
	
	@Column(name="CodCliAnt")
	private String CodCliAnt;

	@Column(name="StatusCliente")
	private int StatusCliente;
	
	@Column(name="Hospedagem")
	private int Hospedagem;

	@Column(name="Cep")
	private String Cep;
	
	@Column(name="Endereco2")
	private String Endereco2;
	
	@Column(name="Bairro2")
	private String Bairro2;
	
	@Column(name="Cidade2")
	private String Cidade2;
	
	@Column(name="Cep2")
	private String Cep2;

	@Column(name="Estado2")
	private String Estado2;

	
	@Column(name="Endereco3")
	private String Endereco3;
	
	@Column(name="Bairro3")
	private String Bairro3;
	
	@Column(name="Cidade3")
	private String Cidade3;
	
	@Column(name="Cep3")
	private String Cep3;

	@Column(name="Estado3")
	private String Estado3;


	@NotNull
	@Column(name="fl_ativo", nullable = false)
	private String FlAtivo;
	
	
	
	// hashCode && equals
	
	
	

	
	
	// Gets & Sets
	
	
	
	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return IdCliente;
	}


	/**
	 * @param idCliente the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		IdCliente = idCliente;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return Codigo != null ? Codigo.trim() : "";
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return RazaoSocial != null ? RazaoSocial.trim() : "";
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		RazaoSocial = razaoSocial;
	}

	/**
	 * @return the fantasia
	 */
	public String getFantasia() {
		return Fantasia != null ? Fantasia.trim() : Fantasia;
	}

	/**
	 * @param fantasia the fantasia to set
	 */
	public void setFantasia(String fantasia) {
		Fantasia = fantasia;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return Endereco != null ? Endereco.trim() : "";
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return Complemento != null ? Complemento.trim() : "";
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		Complemento = complemento;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro() {
		return Bairro != null ? Bairro.trim() : Bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro) {
		Bairro = bairro;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return Cidade != null ? Cidade.trim() : Cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		Cidade = cidade;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return Estado != null ? Estado.trim() : Estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		Estado = estado;
	}

	/**
	 * @return the cnpjCpf
	 */
	public String getCnpjCpf() {
		return CnpjCpf != null ? CnpjCpf.trim() : CnpjCpf;
	}

	/**
	 * @param cnpjCpf the cnpjCpf to set
	 */
	public void setCnpjCpf(String cnpjCpf) {
		CnpjCpf = cnpjCpf;
	}

	/**
	 * @return the inscRg
	 */
	public String getInscRg() {
		return InscRg != null ? InscRg.trim() : "";
	}

	/**
	 * @param inscRg the inscRg to set
	 */
	public void setInscRg(String inscRg) {
		InscRg = inscRg;
	}

	/**
	 * @return the fonedd
	 */
	public String getFonedd() {
		return Fonedd != null ? Fonedd.trim() : "";
	}

	/**
	 * @param fonedd the fonedd to set
	 */
	public void setFonedd(String fonedd) {
		Fonedd = fonedd;
	}

	/**
	 * @return the telefone1
	 */
	public String getTelefone1() {
		return Telefone1 != null ? Telefone1.trim() : "";
	}

	/**
	 * @param telefone1 the telefone1 to set
	 */
	public void setTelefone1(String telefone1) {
		Telefone1 = telefone1;
	}

	/**
	 * @return the ramal1
	 */
	public String getRamal1() {
		return Ramal1 != null ? Ramal1.trim() : "";
	}

	/**
	 * @param ramal1 the ramal1 to set
	 */
	public void setRamal1(String ramal1) {
		Ramal1 = ramal1;
	}

	/**
	 * @return the telefone2
	 */
	public String getTelefone2() {
		return Telefone2 != null ? Telefone2.trim() : Telefone2;
	}

	/**
	 * @param telefone2 the telefone2 to set
	 */
	public void setTelefone2(String telefone2) {
		Telefone2 = telefone2;
	}

	/**
	 * @return the ramal2
	 */
	public String getRamal2() {
		return Ramal2 != null ? Ramal2.trim() : Ramal2;
	}

	/**
	 * @param ramal2 the ramal2 to set
	 */
	public void setRamal2(String ramal2) {
		Ramal2 = ramal2;
	}

	/**
	 * @return the fax
	 */
	public String getFax() {
		return Fax != null ? Fax.trim() : "";
	}

	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		Fax = fax;
	}

	/**
	 * @return the ramalFax
	 */
	public String getRamalFax() {
		return RamalFax != null ? RamalFax.trim() : "";
	}

	/**
	 * @param ramalFax the ramalFax to set
	 */
	public void setRamalFax(String ramalFax) {
		RamalFax = ramalFax;
	}

	/**
	 * @return the paginaweb
	 */
	public String getPaginaweb() {
		return Paginaweb != null ? Paginaweb.trim() : "";
	}

	/**
	 * @param paginaweb the paginaweb to set
	 */
	public void setPaginaweb(String paginaweb) {
		Paginaweb = paginaweb;
	}

	/**
	 * @return the endEmail
	 */
	public String getEndEmail() {
		return EndEmail != null ? EndEmail.trim() : "";
	}

	/**
	 * @param endEmail the endEmail to set
	 */
	public void setEndEmail(String endEmail) {
		EndEmail = endEmail;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return Observacao != null ? Observacao.trim() : "";
	}

	/**
	 * @param observacao the observacao to set
	 */
	public void setObservacao(String observacao) {
		Observacao = observacao;
	}

	/**
	 * @return the gerenteconta
	 */
	public GerenteConta getGerenteconta() {
		return gerenteconta;
	}

	/**
	 * @param gerenteconta the gerenteconta to set
	 */
	public void setGerenteconta(GerenteConta gerenteconta) {
		this.gerenteconta = gerenteconta;
	}

	/**
	 * @return the origemcontato
	 */
/*	
	
	public OrigemContato getOrigemcontato() {
		return origemcontato;
	}
*/
	/**
	 * @param origemcontato the origemcontato to set
	 */
/*	
	public void setOrigemcontato(OrigemContato origemcontato) {
		this.origemcontato = origemcontato;
	}
*/
	/**
	 * @return the qtdLicencas
	 */
	public Long getQtdLicencas() {
		return QtdLicencas;
	}

	/**
	 * @param qtdLicencas the qtdLicencas to set
	 */
	public void setQtdLicencas(Long qtdLicencas) {
		QtdLicencas = qtdLicencas;
	}

	/**
	 * @return the numeroSerie
	 */
	public String getNumeroSerie() {
		return NumeroSerie != null ? NumeroSerie.trim() : NumeroSerie;
	}

	/**
	 * @param numeroSerie the numeroSerie to set
	 */
	public void setNumeroSerie(String numeroSerie) {
		NumeroSerie = numeroSerie;
	}

	/**
	 * @return the codCliMilton
	 */
	public String getCodCliMilton() {
		return CodCliMilton != null ? CodCliMilton.trim() : "";
	}

	/**
	 * @param codCliMilton the codCliMilton to set
	 */
	public void setCodCliMilton(String codCliMilton) {
		CodCliMilton = codCliMilton;
	}

	/**
	 * @return the codCliAnt
	 */
	public String getCodCliAnt() {
		return CodCliAnt != null ? CodCliAnt.trim() : CodCliAnt;
	}

	/**
	 * @param codCliAnt the codCliAnt to set
	 */
	public void setCodCliAnt(String codCliAnt) {
		CodCliAnt = codCliAnt;
	}

	/**
	 * @return the statusCliente
	 */
	public int getStatusCliente() {
		return StatusCliente;
	}

	/**
	 * @param statusCliente the statusCliente to set
	 */
	public void setStatusCliente(int statusCliente) {
		StatusCliente = statusCliente;
	}

	/**
	 * @return the hospedagem
	 */
	public int getHospedagem() {
		return Hospedagem;
	}

	/**
	 * @param hospedagem the hospedagem to set
	 */
	public void setHospedagem(int hospedagem) {
		Hospedagem = hospedagem;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return Cep != null ? Cep.trim() : "";
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		Cep = cep;
	}

	/**
	 * @return the endereco2
	 */
	public String getEndereco2() {
		return Endereco2 != null ? Endereco2.trim() : Endereco2;
	}

	/**
	 * @param endereco2 the endereco2 to set
	 */
	public void setEndereco2(String endereco2) {
		Endereco2 = endereco2;
	}

	/**
	 * @return the bairro2
	 */
	public String getBairro2() {
		return Bairro2 != null ? Bairro2.trim() : "";
	}

	/**
	 * @param bairro2 the bairro2 to set
	 */
	public void setBairro2(String bairro2) {
		Bairro2 = bairro2;
	}

	/**
	 * @return the cidade2
	 */
	public String getCidade2() {
		return Cidade2 != null ? Cidade2.trim() : "";
	}

	/**
	 * @param cidade2 the cidade2 to set
	 */
	public void setCidade2(String cidade2) {
		Cidade2 = cidade2;
	}

	/**
	 * @return the cep2
	 */
	public String getCep2() {
		return Cep2 != null ? Cep2.trim() : "";
	}

	/**
	 * @param cep2 the cep2 to set
	 */
	public void setCep2(String cep2) {
		Cep2 = cep2;
	}

	/**
	 * @return the estado2
	 */
	public String getEstado2() {
		return Estado2 != null ? Estado2.trim() : "";
	}

	/**
	 * @param estado2 the estado2 to set
	 */
	public void setEstado2(String estado2) {
		Estado2 = estado2;
	}

	/**
	 * @return the endereco3
	 */
	public String getEndereco3() {
		return Endereco3 != null ? Endereco3.trim() : "";
	}

	/**
	 * @param endereco3 the endereco3 to set
	 */
	public void setEndereco3(String endereco3) {
		Endereco3 = endereco3;
	}

	/**
	 * @return the bairro3
	 */
	public String getBairro3() {
		return Bairro3 != null ? Bairro3.trim() : "";
	}

	/**
	 * @param bairro3 the bairro3 to set
	 */
	public void setBairro3(String bairro3) {
		Bairro3 = bairro3;
	}

	/**
	 * @return the cidade3
	 */
	public String getCidade3() {
		return Cidade3 != null ? Cidade3.trim() : "";
	}

	/**
	 * @param cidade3 the cidade3 to set
	 */
	public void setCidade3(String cidade3) {
		Cidade3 = cidade3;
	}

	/**
	 * @return the cep3
	 */
	public String getCep3() {
		return Cep3 != null ? Cep3.trim() : "";
	}

	/**
	 * @param cep3 the cep3 to set
	 */
	public void setCep3(String cep3) {
		Cep3 = cep3;
	}

	/**
	 * @return the estado3
	 */
	public String getEstado3() {
		return Estado3 != null ? Estado3.trim() : "";
	}

	/**
	 * @param estado3 the estado3 to set
	 */
	public void setEstado3(String estado3) {
		Estado3 = estado3;
	}

	/**
	 * @return the flAtivo
	 */
	public String getFlAtivo() {
		return FlAtivo != null ? FlAtivo.trim() : "";
	}

	/**
	 * @param flAtivo the flAtivo to set
	 */
	public void setFlAtivo(String flAtivo) {
		FlAtivo = flAtivo;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((IdCliente == null) ? 0 : IdCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (IdCliente == null) {
			if (other.IdCliente != null)
				return false;
		} else if (!IdCliente.equals(other.IdCliente))
			return false;
		return true;
	}
	
	
	
	
	

	
	

}
